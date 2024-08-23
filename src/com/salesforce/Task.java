package com.salesforce;

public class Task {
    private int userId;
    private String update;
    private long timeInEpoc;

    public  Task(int userId, String update, long timeInEpoc){
        this.userId=userId;
        this.update=update;
        this.timeInEpoc=timeInEpoc;
    }

    public int getUserId() {
        return userId;
    }

    public String getUpdate() {
        return update;
    }

    public long getTimeInEpoc() {
        return timeInEpoc;
    }
}
