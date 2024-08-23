package com.salesforce.chess;

public abstract class Piece {
    protected int row;
    protected int column;
    protected PieceType pieceType;

    abstract boolean canMove(Piece piece, int row, int col);
}
