package app.services;

import app.dto.GameCreationParams;
import app.interfaces.plugin.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;


@Service
public class GameServiceImpl implements GamePlugin {

    @Autowired
    Map<String, GamePlugin> gamePlugins;

    @Override
    public UUID getGameId() {
        return gamePlugins.get("game").getGameId();
    }

    @Override
    public String getName(Locale locale) {

        return null;//gamePlugins.get("game").getName();
    }

    @Override
    public Game createGame(GameCreationParams params, Locale locale) {
       // GamePlugin gamePlugin = gamePlugins.get(params.get);

        return null;//gamePlugin.createGame(params, locale);
    }

}
