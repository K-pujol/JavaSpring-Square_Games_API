package app.controllers;

import app.models.record.GameRecord;
import app.dto.GameCreationParams;
import app.dto.GameSaveParams;
import app.services.GameServiceSave;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameServiceSave gss;
    @Autowired
    MessageSource msgSource;


    @PostMapping
    public GameSaveParams createGame(@Valid @RequestBody GameCreationParams params) {
        GameSaveParams game = gss.saveGame(params);
        return game;
    }

    @GetMapping("/test")
    public String test() {
        return "ola que tal";
    }


    @GetMapping("/{gameId}")
    public ResponseEntity<GameRecord> getGame(@PathVariable UUID gameId) {
        GameRecord game = gss.getGame(gameId);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(game);
    }


    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable UUID gameId) {
        GameRecord game = gss.deleteGame(gameId);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
