package app.controllers;

import app.models.record.GameRecord;
import app.dto.game.GameCreationDTO;
import app.dto.game.GameSaveDTO;
import app.services.game.GameServiceSave;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameServiceSave gss;
    @Autowired
    MessageSource msgSource;


    @PostMapping
    public GameSaveDTO createGame(@Valid @RequestBody GameCreationDTO params) {
        GameSaveDTO game = gss.saveGame(params);
        return game;
    }

    @GetMapping("/test")
    public String test() {
        return "ola que tal";
    }


    @GetMapping("/{gameId}")
    public ResponseEntity<GameRecord> getGame(@PathVariable String gameId) {
        GameRecord game = gss.getGame(gameId);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(game);

    }


    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable String gameId) {
        GameRecord game = gss.deleteGame(gameId);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
