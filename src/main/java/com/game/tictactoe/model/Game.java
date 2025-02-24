package com.game.tictactoe.model;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private GameStatus status;
    private String winner;

    public Game(int size) {
        this.board = new Board(size);
        this.player1 = new Player("X", "Player 1");
        this.player2 = new Player("O", "Player 2");
        this.currentPlayer = player1;
        this.status = GameStatus.IN_PROGRESS;
    }

    public boolean makeMove(int row, int col) {
        if (status != GameStatus.IN_PROGRESS) {
            return false;
        }

        if (board.makeMove(row, col, currentPlayer.getSymbol())) {
            if (checkWin(row, col)) {
                status = GameStatus.WON;
                winner = currentPlayer.getName();
            } else if (isBoardFull()) {
                status = GameStatus.DRAW;
            } else {
                switchPlayer();
            }
            return true;
        }
        return false;
    }

    private boolean checkWin(int row, int col) {
        String symbol = currentPlayer.getSymbol();
        String[][] grid = board.getGrid();
        int size = board.getSize();

        // Check row
        boolean win = true;
        for (int c = 0; c < size; c++) {
            if (!grid[row][c].equals(symbol)) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check column
        win = true;
        for (int r = 0; r < size; r++) {
            if (!grid[r][col].equals(symbol)) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check diagonals
        if (row == col) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (!grid[i][i].equals(symbol)) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        if (row + col == size - 1) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (!grid[i][size - 1 - i].equals(symbol)) {
                    win = false;
                    break;
                }
            }
            return win;
        }

        return false;
    }

    private boolean isBoardFull() {
        String[][] grid = board.getGrid();
        for (String[] row : grid) {
            for (String cell : row) {
                if (cell.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getStatus() {
        return status;
    }

    public String getWinner() {
        return winner;
    }
}