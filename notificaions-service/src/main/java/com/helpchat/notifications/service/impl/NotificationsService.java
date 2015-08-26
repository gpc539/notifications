package com.helpchat.notifications.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.helpchat.notifications.dto.CustomerNotificationResponse;
import com.helpchat.notifications.dto.NotificationDispatchConfig;
import com.helpchat.notifications.service.INotificationService;

public class NotificationsService implements INotificationService {

  public CustomerNotificationResponse sendSMS(NotificationDispatchConfig notificationDispatchConfig) {

    List<String> customerNotificationReferences = new ArrayList<String>();
    if (null != notificationDispatchConfig.getTemplateName()) {
         
    }

     /* for (String receipient : notificationDispatchConfig.getRecipients()) {
        SmsDispatchParameter smsDispatchParameter =
            new SmsDispatchParameter(smsText, recipient, appName, marketplaceId.getValue(),
                customerNotificationAuditData, smsDispatchConfig.getCustomerNotificationId(),
                smsDispatchConfig.isSmsDuplicationAllowed());

        CustomerNotificationSendStatus notificationSendStatus =
            customerNotificationMessageSender.sendSmsNotification(smsDispatchParameter);

        customerNotificationReferences.add(smsDispatchParameter.getCustomerNotificationReference());

        if (CustomerNotificationSendStatus.FAILURE.equals(notificationSendStatus)) {
          return new CustomerNotificationResponse(CustomerNotificationSendStatus.FAILURE,
              customerNotificationReferences);
        }
      }
      return new CustomerNotificationResponse(CustomerNotificationSendStatus.SUCCESS,
          customerNotificationReferences);
    }*/
    return null;
  }



}
