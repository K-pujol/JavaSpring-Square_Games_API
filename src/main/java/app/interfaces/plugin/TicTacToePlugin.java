package app.interfaces.plugin;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.OptionalInt;

@Component
public class TicTacToePlugin implements GamePlugin {


    @Autowired
    MessageSource messageSource;

    @Autowired
    TicTacToeGameFactory TTTGameFactory;

    @Value("${game.ticTacToeName:TicTacToe}")
    private String name;

    @Override
    public String getName(Locale locale) {
        return name;
    }

    @Override
    public Game createGame(OptionalInt playerCount, OptionalInt boardSize) {
        TTTGameFactory.createGame();
    }
}
