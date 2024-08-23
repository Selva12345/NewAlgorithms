package com.salesforce.chess;

public class Knight extends Piece{


    public Knight(int row, int column, PieceType pieceType){
        this.column=column;
        this.row=row;
        this.pieceType=pieceType;
    }
    @Override
    boolean canMove(Piece piece, int row, int col) {
        return false;
    }
}
