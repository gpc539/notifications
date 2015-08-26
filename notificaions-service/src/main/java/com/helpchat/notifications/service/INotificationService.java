package com.helpchat.notifications.service;

import com.helpchat.notifications.dto.CustomerNotificationResponse;
import com.helpchat.notifications.dto.NotificationDispatchConfig;

public interface INotificationService {
  public CustomerNotificationResponse sendSMS(NotificationDispatchConfig notificationDispatchConfig);
}
