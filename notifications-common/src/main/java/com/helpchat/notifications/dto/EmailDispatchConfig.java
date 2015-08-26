package com.helpchat.notifications.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.helpchat.notifications.commons.NotificationType;

public class EmailDispatchConfig implements Serializable {
  private static final long serialVersionUID = 2857673836315331632L;

  private Long notificationId;
  private List<String> recipients;
  private Set<String> ccRecipients;
  private Set<String> bccRecipients;
  private String sender;
  private String subject;
  private boolean isEmailDuplicationAllowed = false;
  private NotificationType emailType = NotificationType.TRANSACTIONAL;

  public EmailDispatchConfig() {}

  public EmailDispatchConfig(List<String> recipients, String sender, String subject,
      NotificationType emailType) {
    this.recipients = recipients;
    this.sender = sender;
    this.subject = subject;
    this.emailType = emailType;
  }

  public EmailDispatchConfig(List<String> recipients, Set<String> ccRecipients,
      Set<String> bccRecipients, String sender, String subject) {
    this.recipients = recipients;
    this.ccRecipients = ccRecipients;
    this.bccRecipients = bccRecipients;
    this.sender = sender;
    this.subject = subject;
  }

  public EmailDispatchConfig(List<String> recipients, String sender, String subject) {
    this.recipients = recipients;
    this.ccRecipients = null;
    this.bccRecipients = null;
    this.sender = sender;
    this.subject = subject;
  }

  public List<String> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<String> recipients) {
    this.recipients = recipients;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public boolean isEmailDuplicationAllowed() {
    return isEmailDuplicationAllowed;
  }

  public void setEmailDuplicationAllowed(boolean isEmailDuplicationAllowed) {
    this.isEmailDuplicationAllowed = isEmailDuplicationAllowed;
  }

  public NotificationType getEmailType() {
    return emailType;
  }

  public void setEmailType(NotificationType emailType) {
    this.emailType = emailType;
  }

  public Set<String> getCcRecipients() {
    return ccRecipients;
  }

  public void setCcRecipients(Set<String> ccRecipients) {
    this.ccRecipients = ccRecipients;
  }

  public Set<String> getBccRecipients() {
    return bccRecipients;
  }

  public void setBccRecipients(Set<String> bccRecipients) {
    this.bccRecipients = bccRecipients;
  }

  public Long getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(Long notificationId) {
    this.notificationId = notificationId;
  }



}
