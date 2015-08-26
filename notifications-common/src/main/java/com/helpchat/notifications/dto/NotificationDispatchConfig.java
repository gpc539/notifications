package com.helpchat.notifications.dto;

import java.io.Serializable;
import java.util.List;

import com.helpchat.notifications.commons.NotificationPlatform;
import com.helpchat.notifications.commons.NotificationType;

public class NotificationDispatchConfig implements Serializable {
  private static final long serialVersionUID = 6924262665757011849L;

  private Long notificationId;
  private List<String> recipients;
  private String text;
  private String templateName;
  private NotificationType type = NotificationType.TRANSACTIONAL;
  private NotificationPlatform platform;

  public NotificationDispatchConfig() {}

  public List<String> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<String> recipients) {
    this.recipients = recipients;
  }

  
  public Long getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(Long notificationId) {
    this.notificationId = notificationId;
  }


  public NotificationType getType() {
    return type;
  }

  public void setType(NotificationType type) {
    this.type = type;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getTemplateName() {
    return templateName;
  }

  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }

  public NotificationPlatform getPlatform() {
    return platform;
  }

  public void setPlatform(NotificationPlatform platform) {
    this.platform = platform;
  }
  
}
