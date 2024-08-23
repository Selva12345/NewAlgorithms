package com.salesforce.chess;

public class Bishop  extends Piece{
    @Override
    boolean canMove(Piece piece, int row, int col) {
        return false;
    }
}
