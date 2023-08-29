package com.design;

import java.time.LocalDateTime;

public class Game extends GameValues{
    Game(LocalDateTime dateTime) {
        super(dateTime);
    }

    @Override
    public int score() {
        System.out.println(super.scoreCalculator(12));
        return 0;
    }
    @Override
    public  int scoreCalculator(int values){
        System.out.println("Here");
        return values;
    }
}
