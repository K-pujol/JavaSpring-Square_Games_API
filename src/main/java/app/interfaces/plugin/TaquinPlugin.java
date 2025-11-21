package app.interfaces.plugin;

import app.dto.game.GameCreationDTO;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("Taquin")
public class TaquinPlugin implements GamePlugin {


    @Autowired
    MessageSource messageSource;


    TaquinGameFactory taquingamefactory;

    public TaquinPlugin() {
        this.taquingamefactory = new TaquinGameFactory();
    }


    @Value("${game.TaquinName:Taquin}")
    private String name;

    private UUID gameId;


    @Override
    public UUID getGameId() {
        return gameId;
    }

    @Override
    public String getName(Locale locale) {
        return name;
    }

    @Override
    public Game createGame(GameCreationDTO params, Locale locale) {

        messageSource.getMessage("game.Taquin.created", null, locale);
        return null;
        // return taquingamefactory.createGame(params.getPlayerCount(), params.getBoardSize());
    }

}
