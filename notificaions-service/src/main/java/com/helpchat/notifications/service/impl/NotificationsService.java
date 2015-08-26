package com.helpchat.notifications.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.helpchat.notifications.commons.SmsBO;
import com.helpchat.notifications.dto.CustomerNotificationResponse;
import com.helpchat.notifications.dto.NotificationDispatchConfig;
import com.helpchat.notifications.service.INotificationService;
import com.helpchat.notifications.util.TemplateUtil;

public class NotificationsService implements INotificationService {

  @Autowired
  private TemplateUtil templateUtil;

  public CustomerNotificationResponse sendSMS(NotificationDispatchConfig notificationDispatchConfig) {

    List<String> customerNotificationReferences = new ArrayList<String>();
    if (null != notificationDispatchConfig.getTemplateName()) {
      String smsMessageBody =
          templateUtil.getSMSMessageBody(notificationDispatchConfig.getTemplateName(),
              notificationDispatchConfig.getDispatchParameters());
      notificationDispatchConfig.setText(smsMessageBody);
    }


    for (String receipient : notificationDispatchConfig.getRecipients()) {
      SmsBO smsBO = new SmsBO();
      smsBO.setContent(notificationDispatchConfig.getText());
      smsBO.setTo(receipient);
    }

    return null;
  }



}
