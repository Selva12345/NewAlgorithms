package com.salesforce.observerPatter;

public class MainApp {
    public static void main(String[] args) {
        ServiceDto serviceDto=new ServiceDto();
        User user=new User();
        user.setId("12");
        user.setName("Dhoni");
        User user1=new User();
        user1.setId("13");
        user1.setName("Tendulkar");
        User user2=new User();
        user2.setId("14");
        user2.setName("Sherlock");
        SubscribeService subscribeService=new SubscribeService(serviceDto);
        subscribeService.addSubscriber(user,"Cricket");
        subscribeService.addSubscriber(user1,"Cricket");
        subscribeService.addSubscriber(user2,"Cricket");


        Publish publishService=new PublishService(serviceDto);
        publishService.publishNotification("Cricket");

    }
}
