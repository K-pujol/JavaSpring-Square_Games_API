package app.dao;

import app.GameRecord;
import app.dto.GameCreationParams;
import app.dto.GameSaveParams;
import jakarta.validation.Valid;
import java.util.UUID;

public interface GameDAO {


    GameSaveParams saveGame(@Valid GameCreationParams params);

    GameSaveParams updateGame(@Valid GameSaveParams params);

    GameRecord getGame(UUID gameId);

    GameRecord deleteGame(UUID gameId);

}
