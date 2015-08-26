package com.helpchat.notifications.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.helpchat.notifications.commons.api.HttpClientCaller;
import com.helpchat.notifications.commons.model.ChatNotification;
import com.helpchat.notifications.commons.model.SmsBO;
import com.helpchat.notifications.dto.CustomerNotificationResponse;
import com.helpchat.notifications.dto.NotificationDispatchConfig;
import com.helpchat.notifications.service.INotificationService;

public class NotificationServiceImpl {

  public static final Logger LOGGER = LoggerFactory.getLogger(NotificationServiceImpl.class);

  @Autowired
  private HttpClientCaller caller;

  @Autowired
  @Qualifier("amqpSmsTemplate")
  private RabbitTemplate amqpSmsTemplate;

  public void sendNotification(ChatNotification notification) {
    try {
      Map<String, String> headers = new HashMap<String, String>();
      headers.put("X-AKOSHA-LOGIN", "akoshamobile@akosha.com");
      headers.put("X-AKOSHA-PASSWORD", "kar3.141");
      // caller.httpPOSTApiCall(chatNotificationUrl, null, null,
      // mapper.writeValueAsString(notification), headers);
    } catch (Exception e) {
      LOGGER.error("error in Parsing service response", e);
    }

  }

  public void sendSMSNotification(SmsBO sms) {
    try {
      amqpSmsTemplate.convertAndSend(sms);
    } catch (Exception e) {
      LOGGER.error("Error while pushing sms for mobile number : " + sms.getTo(), e);
    }
  }

  public CustomerNotificationResponse sendSMS(NotificationDispatchConfig notificationDispatchConfig) {
    // TODO Auto-generated method stub
    return null;
  }

}
