package com.roku;

public enum Test {
    UP(0),
    DOWN(1),
    RIGHT(2),
    LEFT(3);
    int val;
    Test(int val){
        this.val=val;
    }
}
