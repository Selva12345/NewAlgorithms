package com.design;

import java.time.LocalDateTime;

public class GameApplication {
    public static void main(String[] args) {
        GameValues game=new Game(LocalDateTime.now());
        game.score();
    }
}
