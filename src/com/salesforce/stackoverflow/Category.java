package com.salesforce.stackoverflow;

public enum Category {
    Technology(0),
    Math(1),
    SoftwareEngineering(2);
    int val;
    Category(int val){
        this.val=val;

    }
}
