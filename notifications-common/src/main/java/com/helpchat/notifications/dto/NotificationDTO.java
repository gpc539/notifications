package com.helpchat.notifications.dto;

import com.helpchat.notifications.commons.NotificationPlatform;

public class NotificationDTO {
  private Long notificationId;
  private String text;
  private NotificationPlatform platform;
  public Long getNotificationId() {
    return notificationId;
  }
  public void setNotificationId(Long notificationId) {
    this.notificationId = notificationId;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  public NotificationPlatform getPlatform() {
    return platform;
  }
  public void setPlatform(NotificationPlatform platform) {
    this.platform = platform;
  }
  

}
