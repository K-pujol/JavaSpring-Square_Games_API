package app.controllers;

import app.GameRecord;
import app.dto.GameCreationParams;
import app.dto.GameSaveParams;
import app.services.GameServiceSave;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Locale;
import java.util.UUID;

@Builder

@RestController
public class GameController {

    @Autowired
    GameServiceSave gss;
    @Autowired
    MessageSource msgSource;

    @PostMapping("/games")
    public ResponseEntity<GameSaveParams> createGame(@Valid @RequestBody GameSaveParams params, Locale locale) {
        GameSaveParams game = gss.saveGame(params);
        return ResponseEntity.ok().body(game);
    }

    @GetMapping("/games/{gameId}")
    public ResponseEntity<GameRecord> getGame(@PathVariable UUID gameId) {
        GameRecord game = gss.getGame(gameId);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(game);
    }


    @DeleteMapping("/games/{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable UUID gameId) {
        GameRecord game = gss.deleteGame(gameId);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
