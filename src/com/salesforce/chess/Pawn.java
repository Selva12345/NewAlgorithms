package com.salesforce.chess;

public class Pawn extends Piece{
    public Pawn(int row, int column, PieceType pieceType) {
        this.row=row;
        this.column=column;
        this.pieceType=pieceType;
    }

    @Override
    boolean canMove(Piece piece, int row, int col) {
        return false;
    }
}
