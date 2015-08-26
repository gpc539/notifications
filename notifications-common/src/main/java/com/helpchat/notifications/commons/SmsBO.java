package com.helpchat.notifications.commons;

import java.io.Serializable;

public class SmsBO implements Serializable {

  private static final long serialVersionUID = 2406146380156026922L;

  private String to;
  private String content;
  private int userId;
  private int state;

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }



}
