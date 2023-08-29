package com.design;

import java.time.LocalDateTime;

public abstract class GameValues {

    LocalDateTime dateTime;
    GameValues(LocalDateTime dateTime){
        this.dateTime=dateTime;
    }
    public abstract int score();

    public  int scoreCalculator(int values){
        return values;
    }
}
