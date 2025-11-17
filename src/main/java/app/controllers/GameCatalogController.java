package app.controllers;

import app.interfaces.GameCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


/**
 * class use for API
 */

@RestController
@RequestMapping("/playablegames")
public class GameCatalogController {

    @Autowired
    private GameCatalog gamecatalog;


    @GetMapping
    public ResponseEntity<Collection<String>> getAllGames() {
        return ResponseEntity.ok(gamecatalog.getGameIdentifiers());
    }


    @PatchMapping("{id}/moves/plays")
    public ResponseEntity<?> playMove() {
        return null;
    }

    @GetMapping("{id}/moves")
    public ResponseEntity<?> getMove() {
        return null;
    }

    @GetMapping("{id}/representations")
    public ResponseEntity<?> getRepresentation() {
        return null;
    }

    @PutMapping("{id}/saves")
    public ResponseEntity<?> saveGame() {
        return null;
    }

    @GetMapping("{id}/victories")
    public ResponseEntity<?> checkVictory() {
        return null;
    }

    @GetMapping("{id}/moves/playables")
    public ResponseEntity<?> getPlayableMove() {
        return null;
    }

    @GetMapping("{id}/tokens")
    public ResponseEntity<?> getAllToken() {
        return null;
    }

    @GetMapping("{id}/tokens/eaten")
    public ResponseEntity<?> getAllEatenToken() {
        return null;
    }

    @GetMapping("{id}/tokens/alive")
    public ResponseEntity<?> getAllAlivePieces() {
        return null;
    }

    @GetMapping("{id}/tokens/moves")
    public ResponseEntity<?> getMoveForAPiece() {
        return null;
    }


}









/*

@GetMapping("{id}")
    public ResponseEntity<PlayedGame> getGameById(@PathVariable String id) {
        PlayedGame game = gamecatalog.getGameById(id);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(game);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGames(@PathVariable("id") String gameIdentifier) {

        boolean deleted = gamecatalog.deleteGame(gameIdentifier);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayedGame> putUpdateGames(@Valid @RequestBody String gameIdentifier) {

        game = gamecatalog.getGameIdentifiers();
        if (game == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        game.majorUpdate(gameIdentifier);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PlayedGame> patchUpdateGames(@Valid @RequestBody String gameIdentifier) {

        game = gamecatalog.getGameIdentifiers();
        if (game == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        game.minorUpdate(gameIdentifier);
        return new ResponseEntity<>(game, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<PlayedGame> createGames(@Valid @RequestBody PlayedGame playedgame) {

        game.createGame(playedgame);
        return new ResponseEntity<>(game, HttpStatus.CREATED);

    }
*/
