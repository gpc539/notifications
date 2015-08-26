package com.helpchat.notifications.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatNotification {

  @JsonProperty("message")
  private String message;

  @JsonProperty("user_id")
  private Long userId;

  @JsonProperty("company_id")
  private Long companyId;

  public ChatNotification(String message, Long userId, Long companyId) {
    this.message = message;
    this.userId = userId;
    this.companyId = companyId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }


}
