package com.helpchat.notifications.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helpchat.notifications.commons.CustomerNotificationSendStatus;
import com.helpchat.notifications.dto.CustomerNotificationResponse;
import com.helpchat.notifications.dto.NotificationDTO;
import com.helpchat.notifications.dto.NotificationDispatchConfig;
import com.helpchat.notifications.service.INotificationService;

@Service
public class NotificationsService implements INotificationService {

  @Autowired
  @Qualifier("amqpPushNotificationTemplate")
  private RabbitTemplate notificationTemplate;

  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsService.class);

  private ObjectMapper mapper;

  {
    mapper = new ObjectMapper();
  }

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
      notificationTemplate.convertAndSend(json);
      CustomerNotificationResponse customerNotificationResponse=new CustomerNotificationResponse();
      return customerNotificationResponse;
    } catch (JsonProcessingException jpe) {
      LOGGER.error("Error in parsing "+jpe);
    }
    return null;

  }



}
