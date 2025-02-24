package com.game.tictactoe.service;

import com.game.tictactoe.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private Game currentGame;

    public Game createGame(int size) {
        currentGame = new Game(size);
        return currentGame;
    }

    public Game makeMove(int row, int col) {
        if (currentGame != null) {
            currentGame.makeMove(row, col);
        }
        return currentGame;
    }
}