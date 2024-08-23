package com.salesforce.observerPatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceDto {
    static Map<String, List<User>>  data;

    public List<User> getData(String category) {
        return data.getOrDefault(category,new ArrayList<>());
    }

    public void setData(User user, String category) {
       List<User> userList=data.getOrDefault(category,new ArrayList<>());
       userList.add(user);
       data.put(category,userList);
    }

    ServiceDto(){
        data=new HashMap<>();
    }
}
