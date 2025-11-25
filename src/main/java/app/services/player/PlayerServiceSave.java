package app.services.player;

import app.dao.jdbc.JDBCPlayerDAO;
import app.interfaces.GameRepository;
import app.interfaces.PlayerRepository;
import app.models.entities.Games;
import app.models.entities.Players;
import app.models.record.GameRecord;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerServiceSave {


    private final JDBCPlayerDAO playerDAO;

    @Autowired
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    public PlayerServiceSave(JDBCPlayerDAO playerDAO, PlayerRepository playerRepository, GameRepository gameRepository) {
        this.playerDAO = playerDAO;
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }


    @Transactional
    public void savePlayer(String gameId, String representation) {

        Games game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found: " + gameId));

        Players player = new Players();
        player.setRepresentation(representation);
        player.setGame(game);

        playerRepository.save(player);
    }

    public GameRecord getPlayer(String gameId) {
        return playerDAO.getPlayer(gameId);
    }

    public GameRecord deletePlayer(String gameId) {
        return playerDAO.deletePlayer(gameId);
    }

}




