package app.services.game;

import app.dao.use.JDBCPlayerDAO;
import app.dto.game.GameResponseDTO;
import app.dto.initialisation.PartyCreationDTO;
import app.dto.player.PlayerSaveDTO;
import app.models.record.GameRecord;
import app.dao.use.JDBCGameDAO;
import app.dto.game.GameSaveDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class GameServiceSave {

    private final JDBCGameDAO jdbcGame;

    public GameServiceSave(JDBCGameDAO jdbcGame) {
        this.jdbcGame = jdbcGame;
    }


    public UUID saveGame(PartyCreationDTO params) {
        GameSaveDTO game = new GameSaveDTO(params);
        return jdbcGame.saveGame(game);
    }


    public GameResponseDTO getGame(String gameId) {
        return jdbcGame.getGame(gameId);
    }

    public GameRecord deleteGame(String gameId) {
        return jdbcGame.deleteGame(gameId);
    }

    public GameSaveDTO updateGame(@Valid GameSaveDTO params) {
        return jdbcGame.updateGame(params);
    }
}




