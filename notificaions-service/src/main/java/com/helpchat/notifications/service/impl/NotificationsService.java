package com.helpchat.notifications.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helpchat.notifications.commons.exception.ErrorCode;
import com.helpchat.notifications.commons.exception.NotificationException;
import com.helpchat.notifications.dto.CustomerNotificationResponse;
import com.helpchat.notifications.dto.NotificationDTO;
import com.helpchat.notifications.dto.NotificationDispatchConfig;
import com.helpchat.notifications.service.INotificationService;
import com.helpchat.notifications.service.IQueueService;

@Service
public class NotificationsService implements INotificationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsService.class);

  private static final ObjectMapper mapper=new ObjectMapper();
  
  @Autowired
  private IQueueService queueService;

  public CustomerNotificationResponse sendSMS(NotificationDispatchConfig notificationDispatchConfig) {
    return null;
  }

  public CustomerNotificationResponse sendPushNotification(
      NotificationDispatchConfig notificationDispatchConfig) {
    try {
      NotificationDTO notification = new NotificationDTO();
      notification.setNotificationId(notificationDispatchConfig.getNotificationId());
      notification.setPlatform(notificationDispatchConfig.getPlatform());
      notification.setText(notificationDispatchConfig.getText());
      String json = mapper.writeValueAsString(notification);
      queueService.sendNotification(json,notificationDispatchConfig.getPlatform());
      return null;
    } catch (JsonProcessingException jpe) {
      LOGGER.error("Error in parsing "+jpe);
    }
    return null;

  }



}
