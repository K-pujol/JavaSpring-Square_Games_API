package app.interfaces.plugin;

import app.dto.initialisation.PartyCreationDTO;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.UUID;

@Component("TicTacToe")

public class TicTacToePlugin implements GamePlugin {


    @Autowired
    MessageSource messageSource;

    TicTacToeGameFactory TTTGameFactory;

    public TicTacToePlugin() {
        this.TTTGameFactory = new TicTacToeGameFactory();
    }

    @Value("${game.ticTacToeName:TicTacToe}")
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
    public Game createGame(PartyCreationDTO params, Locale locale) {
        messageSource.getMessage("game.TicTacToe.created", null, locale);
        return null;
        //return TTTGameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
    }



}
