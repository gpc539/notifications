package com.helpchat.notifications.commons.api;

import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.helpchat.notifications.commons.exception.DependentServiceException;

// TODO rename class
@Component
public class HttpClientCaller {

  @Value(value = "${service.hostname}")
  private String hostname;

  @Value(value = "${service.accesToken}")
  private String accesToken;

  private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientCaller.class);

  public String httpGetApiCall(String requestUrl, String userAccesToken) {
    String output = null;
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpget = new HttpGet(hostname + requestUrl);
    if (userAccesToken == null) {
      userAccesToken = accesToken;
    }
    httpget.setHeader("X-AKOSHA-AUTH", userAccesToken);
    CloseableHttpResponse response = null;
    try {
      response = httpclient.execute(httpget);
      if (response.getStatusLine().getStatusCode() == HttpStatus.NOT_FOUND.value()) {
        return null;
      }
      if (response.getStatusLine().getStatusCode() != HttpStatus.OK.value()) {
        throw new DependentServiceException(requestUrl, response.getStatusLine().getStatusCode());
      }

      output = EntityUtils.toString(response.getEntity());
    } catch (Exception e) {
      throw new DependentServiceException(requestUrl, e);
    }
    return output;
  }

  public String httpPUTApiCall(String requestUrl, Map<String, String> requestParams,
      String helpchatAuthToken, String requestBody) {
    String output = null;
    CloseableHttpClient httpclient = HttpClients.createDefault();
    URIBuilder uriBuilder = null;
    try {
      uriBuilder = new URIBuilder(hostname + requestUrl);
      if (null != requestParams && requestParams.size() != 0) {
        for (String param : requestParams.keySet()) {
          uriBuilder.addParameter(param, requestParams.get(param));
        }
      }
      HttpPut httpPut = new HttpPut(uriBuilder.build());
      if (null != helpchatAuthToken) {
        httpPut.setHeader("X-AKOSHA-AUTH", helpchatAuthToken);
      } else {
        httpPut.setHeader("X-AKOSHA-AUTH", accesToken);
      }
      StringEntity stringEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
      httpPut.setEntity(stringEntity);
      CloseableHttpResponse response = null;
      response = httpclient.execute(httpPut);
      output = EntityUtils.toString(response.getEntity());
      if (response.getStatusLine().getStatusCode() != HttpStatus.OK.value()) {
        LOGGER.error("Bad Response Code:" + response.getStatusLine().getStatusCode() + output);
      }
    } catch (Exception e) {
      LOGGER.error("Error in call to Service:", e);
    }
    return output;
  }


  public String httpPOSTApiCall(String requestUrl, Map<String, String> requestParams,
      String helpchatAuthToken, String requestBody, Map<String, String> requestHeaders) {
    String output = null;
    CloseableHttpClient httpclient = HttpClients.createDefault();
    URIBuilder uriBuilder = null;
    try {
      uriBuilder = new URIBuilder(hostname + requestUrl);
      if (null != requestParams && requestParams.size() != 0) {
        for (String param : requestParams.keySet()) {
          uriBuilder.addParameter(param, requestParams.get(param));
        }
      }
      HttpPost httpPost = new HttpPost(uriBuilder.build());
      if (null == requestHeaders) {
        if (null != helpchatAuthToken) {
          httpPost.setHeader("X-AKOSHA-AUTH", helpchatAuthToken);
        } else {
          httpPost.setHeader("X-AKOSHA-AUTH", accesToken);
        }
      } else {
        for (String key : requestHeaders.keySet()) {
          httpPost.addHeader(key, requestHeaders.get(key));
        }
      }
      StringEntity stringEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
      httpPost.setEntity(stringEntity);
      CloseableHttpResponse response = null;
      response = httpclient.execute(httpPost);
      output = EntityUtils.toString(response.getEntity());
      if (response.getStatusLine().getStatusCode() != HttpStatus.OK.value()) {
        LOGGER.error("Bad Response Code:" + response.getStatusLine().getStatusCode() + output);
      }
    } catch (Exception e) {
      LOGGER.error("Error in call to Service:", e);
    }
    return output;
  }


  public HttpClientCaller(String hostname) {
    super();
    this.hostname = hostname;
  }


  public HttpClientCaller() {
    super();
  }


}
