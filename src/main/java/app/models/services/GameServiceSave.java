package app.models.services;

import app.dto.GameCreationParams;
import app.dto.GameSaveParams;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GameServiceSave {


    public GameSaveParams saveGame(@Valid GameCreationParams params) {
        GameSaveParams saveParams = new GameSaveParams();
        UUID uuid = UUID.randomUUID();

        saveParams.setName(params.getName());
        saveParams.setPlayerCount(params.getPlayerCount());
        saveParams.setBoardSize(params.getBoardSize());
        saveParams.setId(uuid);
        saveParams.setPlayerIds(params.getPlayerIds());
        //saveParams.setBoard(params.getBoard());

        return saveParams;
    }

    public GameSaveParams getGame(UUID gameId) {
        GameSaveParams saveParams = new GameSaveParams();
        saveParams.setId(gameId);
        return saveParams;
    }
}
