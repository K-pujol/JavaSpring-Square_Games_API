package app.controllers;

import app.dto.game.GameResponseDTO;
import app.dto.player.PlayerSaveDTO;
import app.models.record.GameRecord;
import app.dto.initialisation.PartyCreationDTO;
import app.dto.game.GameSaveDTO;
import app.services.game.GameServiceSave;
import app.services.player.PlayerServiceSave;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameServiceSave gamesave;
    @Autowired
    PlayerServiceSave playersave;


    @PostMapping
    public ResponseEntity<Void> createGame(@Valid @RequestBody PartyCreationDTO params) {
        UUID gameId = gamesave.saveGame(params);
        playersave.savePlayer(params, gameId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public String test() {
        return "ola que tal";
    }


    @GetMapping("/{gameId}")
    public ResponseEntity<GameResponseDTO> getGame(@PathVariable String gameId) {
        GameResponseDTO game = gamesave.getGame(gameId);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(game);

    }


    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable String gameId) {
        GameRecord game = gamesave.deleteGame(gameId);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
