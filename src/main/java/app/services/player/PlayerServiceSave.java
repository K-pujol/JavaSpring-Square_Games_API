package app.services.player;

import app.dao.use.JDBCPlayerDAO;
import app.dto.game.GameCreationDTO;
import app.dto.player.PlayerSaveDTO;
import app.models.record.GameRecord;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PlayerServiceSave {


    private final JDBCPlayerDAO playerDAO;

    public PlayerServiceSave() {
        this.playerDAO = new JDBCPlayerDAO();

    }

    public PlayerSaveDTO savePlayer(GameCreationDTO params, UUID gameId) {
        return playerDAO.savePlayer(params, gameId);
    }

    public GameRecord getPlayer(String gameId) {
        return playerDAO.getPlayer(gameId);
    }

    public GameRecord deletePlayer(String gameId) {
        return playerDAO.deletePlayer(gameId);
    }

}




