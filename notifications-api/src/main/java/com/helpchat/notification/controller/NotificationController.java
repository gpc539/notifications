package com.helpchat.notification.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helpchat.notifications.commons.UriConstants;
import com.helpchat.notifications.dto.CustomerNotificationResponse;
import com.helpchat.notifications.dto.NotificationDispatchConfig;



@RestController
@RequestMapping("/v4")
public class NotificationController {
  
  @RequestMapping(value = UriConstants.Notifications.SMS, method = RequestMethod.POST)
  public ResponseEntity<CustomerNotificationResponse> sendSMS(
      @RequestBody NotificationDispatchConfig smsDispatchConfig) {
    return new ResponseEntity<CustomerNotificationResponse>(new CustomerNotificationResponse(),
        HttpStatus.OK);
  }
  
  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public ResponseEntity<CustomerNotificationResponse> sendPushNotification(
      ) {
    
    return new ResponseEntity<CustomerNotificationResponse>(new CustomerNotificationResponse(),
        HttpStatus.OK);
  }



}
