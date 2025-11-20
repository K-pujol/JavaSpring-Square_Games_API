package app.dao;

import app.GameRecord;
import app.dto.GameCreationParams;
import app.dto.GameSaveParams;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LocalGameDAO implements GameDAO {

    private final Map<UUID, GameRecord> gameStore = new HashMap<>();

    @Override
    public GameSaveParams saveGame(@Valid GameCreationParams params) {
        
        UUID uuid = UUID.randomUUID();
        UUID player1Uuid = UUID.randomUUID();
        UUID player2Uuid = UUID.randomUUID();
        GameSaveParams saveParams = new GameSaveParams();

        saveParams.setId(uuid);
        saveParams.setName(params.getName());
        saveParams.setPlayerCount(params.getPlayerCount());
        saveParams.addPlayer(player1Uuid);
        saveParams.addPlayer(player2Uuid);
        saveParams.setBoardSize(params.getBoardSize());

        GameRecord gameRecord = new GameRecord(
                saveParams.getName(),
                saveParams.getPlayerCount(),
                saveParams.getBoardSize(),
                saveParams.getId(),
                saveParams.getPlayerIds()
        );

        gameStore.put(uuid, gameRecord);

        return saveParams;
    }

    @Override
    public GameSaveParams updateGame(GameSaveParams params) {
        return null;
    }

    @Override
    public GameRecord getGame(UUID gameId) {
        return gameStore.get(gameId);
    }

    @Override
    public GameRecord deleteGame(UUID gameId) {
        return gameStore.remove(gameId);
    }
}
