package com.salesforce.chess;

enum PieceType {
    WHITE(1),
    BLACK(2);
    int val;
    PieceType(int val){
        this.val=val;
    }
}
