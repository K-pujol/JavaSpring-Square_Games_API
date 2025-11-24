package app.services.player;

import app.dao.jdbc.JDBCPlayerDAO;
import app.interfaces.PlayerRepository;
import app.models.entities.Players;
import app.models.record.GameRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerServiceSave {


    private final JDBCPlayerDAO playerDAO;

    @Autowired
    private final PlayerRepository playerRepository;

    public PlayerServiceSave(JDBCPlayerDAO playerDAO, PlayerRepository playerRepository) {
        this.playerDAO = playerDAO;
        this.playerRepository = playerRepository;
    }


    public void savePlayer(Players players) {
        playerRepository.save(players);
    }

    public GameRecord getPlayer(String gameId) {
        return playerDAO.getPlayer(gameId);
    }

    public GameRecord deletePlayer(String gameId) {
        return playerDAO.deletePlayer(gameId);
    }

}




