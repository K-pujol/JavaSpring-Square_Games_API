package app.controllers;

import app.interfaces.GameService;
import app.dto.GameCreationParams;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Builder

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/games")
    public String createGame(@Valid @RequestBody GameCreationParams params) {
        gameService.createGame(params);
        return UUID.randomUUID().toString();
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId) {


        return null;
    }

    @DeleteMapping("/games/{gameId}")
    public Object deleteGame(@PathVariable String gameId) {
        gameService.deleteGame(gameId);
        return null;
    }


}
