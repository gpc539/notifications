package com.helpchat.notifications.service;

import com.helpchat.notifications.commons.NotificationPlatform;
import com.helpchat.notifications.commons.SmsBO;

public interface IQueueService {

  public void sendNotification(String json,NotificationPlatform platform);
  public void sendSms(SmsBO sms);
}
