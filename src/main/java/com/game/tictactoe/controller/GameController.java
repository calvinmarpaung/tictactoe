package com.game.tictactoe.controller;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/new")
    public ResponseEntity<Game> newGame(@RequestParam int size) {
        return ResponseEntity.ok(gameService.createGame(size));
    }

    @PostMapping("/move")
    public ResponseEntity<Game> makeMove(@RequestBody Map<String, Integer> move) {
        return ResponseEntity.ok(gameService.makeMove(move.get("row"), move.get("col")));
    }
}
