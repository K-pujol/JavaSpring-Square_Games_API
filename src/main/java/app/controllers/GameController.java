package app.controllers;

import app.dto.game.GameResponseDTO;
import app.dto.initialisation.PartyCreationDTO;

import app.dto.users.UserDTO;
import app.models.record.GameRecord;
import app.services.game.GameServiceSave;
import app.services.player.PlayerServiceSave;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.net.URI;


@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameServiceSave gamesave;
    @Autowired
    PlayerServiceSave playersave;


    @PostMapping
    @Operation(
            summary = "Create a game",
            description = "Create a game choosing between Taquin, TicTacToe and Connect Four",
            tags = {"Game", "Creation"})
    @ApiResponses({
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
    })



    public ResponseEntity<UserDTO> createGame(@Valid @RequestBody PartyCreationDTO dto, @RequestHeader("X-UserId")  String userId ) {


        RestClient restClient = RestClient.builder().build();

        UserDTO response = restClient.get()
                .uri("http://localhost:8081/users/{id}", userId)
                .header("X-UserId", userId)
                .retrieve()
                .body(UserDTO.class);

        String gameId = gamesave.saveGame(dto.getGameName(), dto.getBoardSize());

        playersave.savePlayer(gameId, dto.getPlayerOneRepresentation());
        playersave.savePlayer(gameId, dto.getPlayerTwoRepresentation());

        return ResponseEntity.ok(response);
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
