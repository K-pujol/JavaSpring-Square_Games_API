package app.models.services;

import app.GameRecord;
import app.dto.GameCreationParams;
import app.dto.GameSaveParams;
import fr.le_campus_numerique.square_games.engine.Game;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GameServiceSave {

    private final Map<UUID, GameRecord> gameStore = new HashMap<>();

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

    public GameRecord getGame(UUID gameId) {
        return gameStore.get(gameId);
    }

    public GameRecord deleteGame(UUID gameId) {
        return gameStore.remove(gameId);
    }
}


