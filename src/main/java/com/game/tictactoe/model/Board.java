package com.game.tictactoe.model;

import java.util.Arrays;

public class Board {
    private final String[][] grid;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.grid = new String[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (String[] row : grid) {
            Arrays.fill(row, "");
        }
    }

    public boolean makeMove(int row, int col, String symbol) {
        if (isValidMove(row, col)) {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && grid[row][col].isEmpty();
    }

    public String[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }
}
