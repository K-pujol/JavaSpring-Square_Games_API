package app.dao.use;

import app.dto.player.PlayerSaveDTO;
import app.models.record.GameRecord;
import app.dao.GameDAO;
import app.dto.game.GameCreationDTO;
import app.dto.game.GameSaveDTO;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LocalGameDAO implements GameDAO {

    private final Map<UUID, GameRecord> gameStore = new HashMap<>();


    @Override
    public GameSaveDTO saveGame(@Valid GameCreationDTO params) {

        UUID uuid = UUID.randomUUID();
        UUID player1Uuid = UUID.randomUUID();
        UUID player2Uuid = UUID.randomUUID();

        GameSaveDTO saveParams = new GameSaveDTO(params);
        PlayerSaveDTO gameSaveParams = new PlayerSaveDTO(params);

        saveParams.setId(uuid);
        saveParams.setName(params.getName());
        saveParams.setBoardSize(params.getBoardSize());
       // gameSaveParams.getRepresentation(uuid);


        GameRecord gameRecord = new GameRecord(
                saveParams.getName(),
                saveParams.getBoardSize(),
                saveParams.getId(),
                gameSaveParams.getRepresentation()
        );

        gameStore.put(uuid, gameRecord);

        return saveParams;
    }

    @Override
    public GameSaveDTO updateGame(GameSaveDTO params) {
        return null;
    }

    @Override
    public GameRecord getGame(String gameId) {
        gameStore.get(gameId);
        return null;
    }

    @Override
    public GameRecord deleteGame(String gameId) {
        return gameStore.remove(gameId);
    }
}
