package app.interfaces.plugin;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.OptionalInt;

@Component
public class ConnectFourPlugin implements GamePlugin {


    @Autowired
    MessageSource messageSource;

    @Autowired
    ConnectFourGameFactory ConnectFourGameFactory;

    @Value("${game.ticTacToeName:ConnectFour}")
    private String name;


    @Override
    public String getName(Locale locale) {
        return name;
    }

    @Override
    public Game createGame(OptionalInt playerCount, OptionalInt boardSize) {
        ConnectFourGameFactory.createGame();
    }
}
