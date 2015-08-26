package com.helpchat.notifications.commons;

public enum NotificationPlatform {
  APPLE(0),GOOGLE(1);
  private int id;
  
  NotificationPlatform(int id){
      this.id = id;
  }
  
  public int getId(){
      return id;
  }

}
