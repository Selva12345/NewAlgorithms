package com.salesforce.observerPatter;

import java.util.ArrayList;
import java.util.List;

public class PublishService implements Publish{
        ServiceDto serviceDto;
    PublishService(ServiceDto serviceDto){
       this.serviceDto = serviceDto;
    }
    @Override
    public void publishNotification(String  category) {

        List<User> userList = serviceDto.getData(category);
        System.out.println("Notifications Sent to below people: ");
        for (User user:userList){
            System.out.println(user.toString());
        }
    }
}
