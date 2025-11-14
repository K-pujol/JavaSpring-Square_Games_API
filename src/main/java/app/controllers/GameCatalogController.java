package app.controllers;

import app.interfaces.GameCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


/**
 * class use for API
 */

@RestController
@RequestMapping("/game")
public class GameCatalogController {

    @Autowired
    private GameCatalog gamecatalog;


    @GetMapping
    public Collection<String> getGamesID() {
        return gamecatalog.getGameIdentifiers();
    }
}
