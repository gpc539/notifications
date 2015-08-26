package com.helpchat.notifications.dto;

import java.io.Serializable;
import java.util.List;

public class SmsDispatchConfig implements Serializable {
  private static final long serialVersionUID = 6924262665757011849L;

  private Long notificationId;
  private List<String> recipients;
  private boolean isSmsDuplicationAllowed = false;

  public SmsDispatchConfig() {}

  public List<String> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<String> recipients) {
    this.recipients = recipients;
  }

  public boolean isSmsDuplicationAllowed() {
    return isSmsDuplicationAllowed;
  }

  public void setSmsDuplicationAllowed(boolean isSmsDuplicationAllowed) {
    this.isSmsDuplicationAllowed = isSmsDuplicationAllowed;
  }

  public Long getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(Long notificationId) {
    this.notificationId = notificationId;
  }

}
