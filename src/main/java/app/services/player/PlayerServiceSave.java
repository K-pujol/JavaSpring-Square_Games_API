package app.services.player;

import app.dao.use.JDBCPlayerDAO;
import app.dto.initialisation.PartyCreationDTO;
import app.dto.player.PlayerSaveDTO;
import app.models.record.GameRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PlayerServiceSave {

    @Autowired
    private final JDBCPlayerDAO playerDAO;

    public PlayerServiceSave(JDBCPlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }


    public void savePlayer(PartyCreationDTO params, UUID gameId) {

        PlayerSaveDTO playerOne = new PlayerSaveDTO(params.getPlayerOneRepresentation(), gameId);
        PlayerSaveDTO playerTwo = new PlayerSaveDTO(params.getPlayerTwoRepresentation(), gameId);

        playerDAO.savePlayer(playerOne);
        playerDAO.savePlayer(playerTwo);

    }

    public GameRecord getPlayer(String gameId) {
        return playerDAO.getPlayer(gameId);
    }

    public GameRecord deletePlayer(String gameId) {
        return playerDAO.deletePlayer(gameId);
    }

}




