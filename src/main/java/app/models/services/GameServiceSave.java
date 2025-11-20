package app.models.services;

import app.GameRecord;
import app.dao.LocalGameDAO;
import app.dto.GameCreationParams;
import app.dto.GameSaveParams;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class GameServiceSave {


    private final LocalGameDAO locGame;

    public GameServiceSave() {
        this.locGame = new LocalGameDAO();
    }


    public GameSaveParams saveGame(@Valid GameCreationParams params) {

        return locGame.saveGame(params);
    }

    public GameRecord getGame(UUID gameId) {
        return locGame.getGame(gameId);
    }

    public GameRecord deleteGame(UUID gameId) {
        return locGame.deleteGame(gameId);
    }

    public GameSaveParams updateGame(@Valid GameSaveParams params) {
        return locGame.updateGame(params);
    }
}




