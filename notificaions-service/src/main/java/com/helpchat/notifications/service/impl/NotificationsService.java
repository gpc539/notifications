package com.helpchat.notifications.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helpchat.notifications.dto.CustomerNotificationResponse;
import com.helpchat.notifications.dto.NotificationDTO;
import com.helpchat.notifications.dto.NotificationDispatchConfig;
import com.helpchat.notifications.service.INotificationService;
import com.helpchat.notifications.service.IQueueService;
import com.helpchat.notifications.util.TemplateUtil;

@Service
public class NotificationsService implements INotificationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsService.class);

  private static final ObjectMapper mapper=new ObjectMapper();
  
  @Autowired
  private IQueueService queueService;
  @Autowired
  private TemplateUtil templateUtil;

  public CustomerNotificationResponse sendSMS(NotificationDispatchConfig notificationDispatchConfig) {
    return null;
  }

  public CustomerNotificationResponse sendPushNotification(
      NotificationDispatchConfig notificationDispatchConfig) {
    try {
      NotificationDTO notification = new NotificationDTO();
      notification.setNotificationId(notificationDispatchConfig.getNotificationId());
      notification.setPlatform(notificationDispatchConfig.getPlatform());
      notification.setText(notificationDispatchConfig.getText());
      String json = mapper.writeValueAsString(notification);
      queueService.sendNotification(json,notificationDispatchConfig.getPlatform());
      return null;
    } catch (JsonProcessingException jpe) {
      LOGGER.error("Error in parsing "+jpe);
    }
    return null;
  }
      /*
     * for (String receipient : notificationDispatchConfig.getRecipients()) { SmsDispatchParameter
     * smsDispatchParameter = new SmsDispatchParameter(smsText, recipient, appName,
     * marketplaceId.getValue(), customerNotificationAuditData,
     * smsDispatchConfig.getCustomerNotificationId(), smsDispatchConfig.isSmsDuplicationAllowed());
     * 
     * CustomerNotificationSendStatus notificationSendStatus =
     * customerNotificationMessageSender.sendSmsNotification(smsDispatchParameter);
     * 
     * customerNotificationReferences.add(smsDispatchParameter.getCustomerNotificationReference());
     * 
     * if (CustomerNotificationSendStatus.FAILURE.equals(notificationSendStatus)) { return new
     * CustomerNotificationResponse(CustomerNotificationSendStatus.FAILURE,
     * customerNotificationReferences); } } return new
     * CustomerNotificationResponse(CustomerNotificationSendStatus.SUCCESS,
     * customerNotificationReferences); }
     */

  }

