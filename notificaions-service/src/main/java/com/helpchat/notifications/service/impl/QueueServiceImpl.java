package com.helpchat.notifications.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.helpchat.notifications.commons.NotificationPlatform;
import com.helpchat.notifications.commons.SmsBO;
import com.helpchat.notifications.service.IQueueService;

@Service
public class QueueServiceImpl implements IQueueService {

  @Autowired
  @Qualifier("amqpGooglePushNotificationTemplate")
  private RabbitTemplate googleNotification;

  @Autowired
  @Qualifier("amqpApplePushNotificationTemplate")
  private RabbitTemplate appleNotification;

  @Autowired
  @Qualifier("amqpSmsTemplate")
  private RabbitTemplate amqpSmsTemplate;


  public void sendNotification(String json, NotificationPlatform platform) {
    if (NotificationPlatform.GOOGLE.equals(platform))
      googleNotification.convertAndSend(json);
    else if (NotificationPlatform.APPLE.equals(platform))
      appleNotification.convertAndSend(json);
  }

  public void sendSms(SmsBO sms) {
    amqpSmsTemplate.convertAndSend(sms);
  }

}
