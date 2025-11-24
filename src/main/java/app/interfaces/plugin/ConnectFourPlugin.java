package app.interfaces.plugin;

import app.dto.initialisation.PartyCreationDTO;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.UUID;


@Component("ConnectFour")
public class ConnectFourPlugin implements GamePlugin {

    @Autowired
    MessageSource messageSource;

    ConnectFourGameFactory connectfourgamefactory;

    public ConnectFourPlugin() {
        this.connectfourgamefactory = new ConnectFourGameFactory();
    }

    @Value("${game.ConnectFour:ConnectFour}")
    private String name;

    @Override
    public UUID getGameId() {
        return null;
    }

    @Override
    public String getName(Locale locale) {
        return name;
    }

    @Override
    public Game createGame(PartyCreationDTO params, Locale locale) {
        messageSource.getMessage("game.ConnectFour.created", null, locale);
        return null;
       // return connectfourgamefactory.createGame(params.getPlayerCount(), params.getBoardSize());
    }

}
