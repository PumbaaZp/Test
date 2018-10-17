package com.pro.eightQueens;

public class Queen {

    private static final int MAX_NUM = 8;

    int chessBoard[][] = new int[MAX_NUM][MAX_NUM];

    boolean check(int x, int y){
        for(int i=0; i<y; i++){
            if(chessBoard[x][i] == 1){  //纵向
                return false;
            }
            if(x-1-i >= 0 && chessBoard[x-1-i][y-1-i] == 1){    //左侧斜向
                return false;
            }
            if(x+1+i < MAX_NUM && chessBoard[x+1+i][y-1-i] == 1){   //右侧斜向
                return false;
            }
        }
        return true;
    }

    boolean settleQueen(int y){
        if(y == MAX_NUM){
            return true;
        }
        for(int i=0; i<MAX_NUM; i++){
            for(int x=0; x<MAX_NUM; x++){
                chessBoard[x][y] = 0;
            }
            if(check(i, y)){
                chessBoard[i][y] = 1;
                if(settleQueen(y+1)){
                    return true;
                }
            }
        }
        return false;
    }

    void printChessBoard(){
        for(int i=0; i<MAX_NUM; i++){
            for(int j=0; j<MAX_NUM; j++){
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.settleQueen(0);
        queen.printChessBoard();
    }
}
