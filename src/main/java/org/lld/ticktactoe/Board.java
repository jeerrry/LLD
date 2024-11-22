package org.lld.ticktactoe;

import java.util.Arrays;

public class Board {
    private final int size;
    private final char[][] board;

    public Board(int size) {
        this.size = size;
        board = new char[size][size];
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == 0;
    }

    public boolean move(int row, int col, char mark) {
        if (!isValidMove(row, col)) return false;

        board[row][col] = mark;

        return true;
    }

    public GameState isVictory(char mark) {
        // Vertical and Horizontal Checks
        boolean horizontal = true;
        boolean vertical = true;
        for (int i = 0; i < board.length; i++) {
            // Horizontal
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != mark) {
                    horizontal = false;
                    break;
                }
            }

            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != mark) {
                    vertical = false;
                    break;
                }
            }

            if (horizontal || vertical) return GameState.VICTORY;
        }

        // Diagonal
        boolean leftDiagonal = true;
        boolean rightDiagonal = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != mark) leftDiagonal = false;
            if (board[i][board[i].length - 1 - i] != mark) rightDiagonal = false;
        }

        if (leftDiagonal || rightDiagonal) return GameState.VICTORY;

        if (isBoardFull()) return GameState.DRAW;

        return GameState.PLAY;
    }

    public boolean isBoardFull() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == 0) return false;
            }
        }

        return true;
    }

    public void resetBoard() {
        for (char[] chars : board) {
            Arrays.fill(chars, (char) 0);
        }
    }

    public void displayBoard() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar == 0 ? '.' : aChar);
            }
            System.out.println();
        }
    }
}
