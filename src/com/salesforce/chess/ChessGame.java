package com.salesforce.chess;

public class ChessGame {
    Piece[][] board;

    public ChessGame(){
    }

    public void initialize(){
       board = new Piece[8][8];
        for(int i=0;i<8;i++){
            board[0][i]=new Pawn(0,i,PieceType.WHITE);
        }
        for(int i=0;i<8;i++){
            board[6][i]=new Pawn(6,i,PieceType.BLACK);
        }
    }
    public boolean makeMove(Piece piece, int x, int y){
        if(piece.canMove(piece,x,y)){
            updateBoard(piece,x,y);
            return true;
        }
        return false;
    }
    public void updateBoard(Piece piece, int x, int y){

    }
}
