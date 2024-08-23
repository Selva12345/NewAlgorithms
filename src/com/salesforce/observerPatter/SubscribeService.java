package com.salesforce.observerPatter;

public class SubscribeService implements Subscribe {
        ServiceDto serviceDto;
        SubscribeService(ServiceDto serviceDto){
            this.serviceDto=serviceDto;
        }
    @Override
    public void addSubscriber(User user, String category) {

        serviceDto.setData(user,category);
        System.out.println("Subscriber " +user.getName()+" added successfully");
    }
}
