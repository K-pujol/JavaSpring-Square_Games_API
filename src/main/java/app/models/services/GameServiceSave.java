package app.models.services;

import app.dto.GameCreationParams;
import app.dto.GameSaveParams;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class GameServiceSave {


    public GameSaveParams saveGame(@Valid GameCreationParams params) {
        GameSaveParams saveParams = new GameSaveParams();

        saveParams.setName(params.getName());
        saveParams.setPlayerCount(params.getPlayerCount());
        saveParams.setBoardSize(params.getBoardSize());
        saveParams.setId(params.getId());
        saveParams.setPlayerIds(params.getPlayerIds());
        //saveParams.setBoard(params.getBoard());

        return saveParams;
    }

}
