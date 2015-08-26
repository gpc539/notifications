package com.helpchat.notifications.model;

import com.helpchat.notifications.commons.NotificationType;

public class SmsDispatch {
  private Long notificationId;
  private String recipients;
  private String text;
  private String templateName;
  private NotificationType type = NotificationType.TRANSACTIONAL;
  private String notificationReference;

  public Long getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(Long notificationId) {
    this.notificationId = notificationId;
  }

  public String getRecipients() {
    return recipients;
  }

  public void setRecipients(String recipients) {
    this.recipients = recipients;
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

  public NotificationType getType() {
    return type;
  }

  public void setType(NotificationType type) {
    this.type = type;
  }

  public String getNotificationReference() {
    return notificationReference;
  }

  public void setNotificationReference(String notificationReference) {
    this.notificationReference = notificationReference;
  }


}
