package app.dao;

import app.models.record.GameRecord;
import app.dto.game.GameCreationDTO;
import app.dto.game.GameSaveDTO;
import jakarta.validation.Valid;

public interface GameDAO {

    GameSaveDTO saveGame(@Valid GameCreationDTO params);

    GameSaveDTO updateGame(@Valid GameSaveDTO params);

    GameRecord getGame(String gameId);

    GameRecord deleteGame(String gameId);

}
