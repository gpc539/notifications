package com.helpchat.notifications.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helpchat.notifications.commons.SmsBO;
import com.helpchat.notifications.dto.CustomerNotificationResponse;
import com.helpchat.notifications.dto.NotificationDTO;
import com.helpchat.notifications.dto.NotificationDispatchConfig;
import com.helpchat.notifications.service.INotificationService;
import com.helpchat.notifications.service.IQueueService;
import com.helpchat.notifications.util.TemplateUtil;

@Service
public class NotificationsService implements INotificationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsService.class);

  private static final ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private IQueueService queueService;
  @Autowired
  private TemplateUtil templateUtil;

  public CustomerNotificationResponse sendSMS(NotificationDispatchConfig notificationDispatchConfig) {
    if (null != notificationDispatchConfig.getTemplateName()) {
      String smsMessageBody =
          templateUtil.getSMSMessageBody(notificationDispatchConfig.getTemplateName(),
              notificationDispatchConfig.getDispatchParameters());
      notificationDispatchConfig.setText(smsMessageBody);
    }
    for (String receipient : notificationDispatchConfig.getRecipients()) {
      SmsBO smsBO = new SmsBO();
      smsBO.setContent(notificationDispatchConfig.getText());
      smsBO.setTo(receipient);
      queueService.sendSms(smsBO);
    }
    return null;
  }

  public CustomerNotificationResponse sendPushNotification(
      NotificationDispatchConfig notificationDispatchConfig) {
    try {
      NotificationDTO notification = new NotificationDTO();
      notification.setNotificationId(notificationDispatchConfig.getNotificationId());
      notification.setPlatform(notificationDispatchConfig.getPlatform());
      if (null != notificationDispatchConfig.getTemplateName()) {
        String smsMessageBody =
            templateUtil.getSMSMessageBody(notificationDispatchConfig.getTemplateName(),
                notificationDispatchConfig.getDispatchParameters());
        notificationDispatchConfig.setText(smsMessageBody);
      }
      notification.setText(notificationDispatchConfig.getText());
      String json = mapper.writeValueAsString(notification);
      queueService.sendNotification(json, notificationDispatchConfig.getPlatform());
      return null;
    } catch (JsonProcessingException jpe) {
      LOGGER.error("Error in parsing " + jpe);
    }
    return null;
  }


}
