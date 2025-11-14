package app.models;

import app.interfaces.GameCatalog;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class GameCatalogImpl implements GameCatalog {


    private TicTacToeGameFactory TTTGameFactory;
    private ConnectFourGameFactory CFGameFactory;
    private TaquinGameFactory TaquinGameFactory;

    public GameCatalogImpl() {
        this.TTTGameFactory = new TicTacToeGameFactory();
        this.CFGameFactory = new ConnectFourGameFactory();
        this.TaquinGameFactory = new TaquinGameFactory();
    }

    @Override
    public Collection<String> getGameIdentifiers() {

        Collection<String> gameIdentifiers = new ArrayList<>();

        gameIdentifiers.add(TTTGameFactory.getGameFactoryId());
        gameIdentifiers.add(CFGameFactory.getGameFactoryId());
        gameIdentifiers.add(TaquinGameFactory.getGameFactoryId());
        return gameIdentifiers;
    }
}
