package app.services;

import app.GameRecord;
import app.dao.use.JDBCGameDAO;
import app.dto.GameSaveParams;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class GameServiceSave {


    private final JDBCGameDAO jdbcGame;

    public GameServiceSave() {
        this.jdbcGame = new JDBCGameDAO();
    }

    public GameSaveParams saveGame(GameSaveParams params) {

        return jdbcGame.saveGame(params);
    }

    public GameRecord getGame(UUID gameId) {
        return jdbcGame.getGame(gameId);
    }

    public GameRecord deleteGame(UUID gameId) {
        return jdbcGame.deleteGame(gameId);
    }

    public GameSaveParams updateGame(@Valid GameSaveParams params) {
        return jdbcGame.updateGame(params);
    }
}




