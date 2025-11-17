package app.models.services;

import app.interfaces.plugin.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.OptionalInt;

@Service
public class GameServiceImpl implements GamePlugin {

    @Autowired
    List<GamePlugin> gamePlugins;

    @Override
    public String getName(Locale locale) {
        return "";
    }

    @Override
    public Game createGame(OptionalInt playerCount, OptionalInt boardSize) {

    }
}








    /*
    private TicTacToeGameFactory TTTGameFactory;
    private ConnectFourGameFactory CFGameFactory;
    private TaquinGameFactory TaquinGameFactory;

    public GameServiceImpl() {
        this.TTTGameFactory = new TicTacToeGameFactory();
        this.CFGameFactory = new ConnectFourGameFactory();
        this.TaquinGameFactory = new TaquinGameFactory();
    }


    public String createGame(GameCreationParams params) {

        switch (params.getName()) {
            case "TicTacToe" -> TTTGameFactory.createGame(params.getPlayerCount(), params.getPlayerCount());
            case "ConnectFour" -> CFGameFactory.createGame(params.getPlayerCount(), params.getPlayerCount());
            case "Taquin" -> TaquinGameFactory.createGame(params.getPlayerCount(), params.getPlayerCount());
        }
        return params.getName();
    }
    @Override
    public void deleteGame(String gameId) {

    }
*/