package app.services.game;

import app.dto.game.GameResponseDTO;
import app.interfaces.GameRepository;
import app.models.entities.Games;
import app.models.record.GameRecord;
import app.dao.jdbc.JDBCGameDAO;
import app.dto.game.GameSaveDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class GameServiceSave {

    private final JDBCGameDAO jdbcGame;
    private final GameRepository gameRepository;


    public GameServiceSave(JDBCGameDAO jdbcGame, GameRepository gameRepository) {
        this.jdbcGame = jdbcGame;
        this.gameRepository = gameRepository;
    }


    public String saveGame(String name, int boardSize) {
        Games game = new Games();
        game.setName(name);
        game.setBoard_size(boardSize);

        game = gameRepository.save(game);

        return game.getUUID();
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




