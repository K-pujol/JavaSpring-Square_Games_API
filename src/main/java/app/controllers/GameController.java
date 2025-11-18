package app.controllers;

import app.dto.GameCreationParams;
import app.dto.GameSaveParams;
import app.models.services.GameServiceImpl;
import app.models.services.GameServiceSave;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@Builder

@RestController
public class GameController {

    @Autowired
    private GameServiceSave gameSave;

    @Autowired
    private GameServiceImpl gameImpl;

    @Autowired
    GameServiceSave gss;

    @PostMapping("/games")
    public ResponseEntity<GameSaveParams> createGame(@Valid @RequestBody GameCreationParams params) {
        GameSaveParams game = gameSave.saveGame(params);
        return ResponseEntity.ok().body(game);
    }

    @GetMapping("/games/{gameId}")
    public UUID getGame(@PathVariable UUID gameId) {

       // Game game = gameService.get();

        return null;//game.getId();
    }

    @DeleteMapping("/games/{gameId}")
    public Object deleteGame(@PathVariable String gameId) {
        //gameService.deleteGame(gameId);
        return null;
    }


}
