package org.example.Task_1;

import java.util.Random;
import java.util.Scanner;

public class XOGame {
    public static  Scanner scannerStr = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("1 }Play with my friend  ");
        System.out.println("2 }Computer  ");
        System.out.print("Choose : ");
        String str = scannerStr.nextLine();
        if (str.equals("1")){
            playWithMyfriend();
        }
        else {
            playWithComputer();
        }


    }

    private static void playWithComputer() {
        char[][] board = {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };
        printBoardForUser(board);

        char currentPlayer = 'X' ;
        boolean gameFinished = false ;
        int row = 0, col=0 ;
        while (!gameFinished){
            if (currentPlayer=='X'){
                int [] move = getPlayerMove(board , currentPlayer);
                 row = move[0] ;
                 col = move[1] ;
            }
            else {


                Random random = new Random();
                row = random.nextInt(0,3);
                col = random.nextInt(0,3);
            }



            if (isValidMove(board , row , col)){
                board[row][col] = currentPlayer;
                printBoardForUser(board);

                if (isWinner(board,currentPlayer)){
                    System.out.println("Winner : {"+currentPlayer+"}");
                    gameFinished = true ;
                } else if (isBoardFull(board)) {
                    System.out.println("It's a draw!");
                    gameFinished = true ;
                }
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }else {
                System.out.println("Already written");
            }
        }

    }

    private static void playWithMyfriend() {
        char[][] board = {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };

        printBoardForUser(board);

        char currentPlayer = 'X' ;
        boolean gameFinished = false ;

        while (!gameFinished){
            int [] move = getPlayerMove(board , currentPlayer);
            int row = move[0] ;
            int col = move[1] ;

            if (isValidMove(board , row , col)){
                board[row][col] = currentPlayer;
                printBoardForUser(board);

                if (isWinner(board,currentPlayer)){
                    System.out.println("Winner : {"+currentPlayer+"}");
                    gameFinished = true ;
                } else if (isBoardFull(board)) {
                    System.out.println("It's a draw!");
                    gameFinished = true ;
                }
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }else {
                System.out.println("Already written");
            }
        }

    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean isWinner(char[][] board , char player){
        return (checkRows(board , player) || checkColumns(board , player) ||checkDiogonals(board , player));
    }

    private static boolean checkDiogonals(char[][] board, char player) {
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean checkColumns(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRows(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static int[] getPlayerMove(char[][] board, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player "+currentPlayer+", enter your move (row and column) example 1 2");

        int row = scanner.nextInt() ;
        int col = scanner.nextInt() ;

        return new int[]{row , col};
    }

    private static void printBoardForUser(char[][] board) {

        System.out.println("**************");

        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row){
                System.out.print(cell+" | ");
            }
            System.out.println();
            System.out.println("**************");
        }
    }
}
