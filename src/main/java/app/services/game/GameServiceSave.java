package app.services.game;

import app.dao.use.JDBCPlayerDAO;
import app.models.record.GameRecord;
import app.dao.use.JDBCGameDAO;
import app.dto.game.GameCreationDTO;
import app.dto.game.GameSaveDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;


@Service
public class GameServiceSave {


    private final JDBCGameDAO jdbcGame;
    private final JDBCPlayerDAO jdbcPlayer;

    public GameServiceSave() {
        this.jdbcGame = new JDBCGameDAO();
        this.jdbcPlayer = new JDBCPlayerDAO();

    }


    public GameSaveDTO saveGame(GameCreationDTO params) {
        GameSaveDTO savedGame = jdbcGame.saveGame(params);
        jdbcPlayer.savePlayer(params, savedGame.getId());
        return savedGame;
    }

    public GameRecord getGame(String gameId) {
        return jdbcGame.getGame(gameId);
    }

    public GameRecord deleteGame(String gameId) {
        return jdbcGame.deleteGame(gameId);
    }

    public GameSaveDTO updateGame(@Valid GameSaveDTO params) {
        return jdbcGame.updateGame(params);
    }
}




