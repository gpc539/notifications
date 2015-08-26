package com.helpchat.notifications.util;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.helpchat.notifications.commons.exception.NotificationException;
import com.helpchat.notifications.dto.KeyValuePair;

public class TemplateUtil {

  @Autowired
  private VelocityEngine smsVelocityEngine;

  private static final Logger LOGGER = LoggerFactory.getLogger(TemplateUtil.class);

  public String getSMSMessageBody(String smsTemplateName, List<KeyValuePair> smsTemplateKeyValueMap) {
    StringWriter sw = new StringWriter();
    Map<String, String> renderMap = constructRenderMap(smsTemplateKeyValueMap);
    try {
      VelocityContext context = new VelocityContext(renderMap);
      Template template = smsVelocityEngine.getTemplate(smsTemplateName);
      if (template != null) {
        template.merge(context, sw);
      }
    } catch (ResourceNotFoundException resourceNotFoundException) {
      String errorMessage = "No SMS template found in db with name : " + smsTemplateName;
      LOGGER.error(errorMessage, resourceNotFoundException);
    } catch (Exception e) {
      String errorMessage = "Error in getting MessageBody from SMS template : " + smsTemplateName;
      LOGGER.error(errorMessage, e);
      throw new NotificationException(e);
    }
    return sw.toString();
  }

  private Map<String, String> constructRenderMap(List<KeyValuePair> templateKeyValueMap) {
    Map<String, String> renderMap = new HashMap<String, String>();
    if (templateKeyValueMap != null) {
      for (KeyValuePair keyValuePair : templateKeyValueMap) {
        renderMap.put(keyValuePair.getKey(), keyValuePair.getValue());
      }
    }
    return renderMap;
  }
}
