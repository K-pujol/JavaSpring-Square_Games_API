package app.dao.jdbc;

import app.DBConnection;
import app.dao.PlayerDAO;
import app.dto.player.PlayerSaveDTO;
import app.models.record.GameRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Repository
public class JDBCPlayerDAO implements PlayerDAO {

    @Autowired
    private Connection connection;


    @Override
    public void savePlayer(PlayerSaveDTO params) {
    /*    String sql = "INSERT INTO players (games_id, representation, UUID) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, params.getGameId().toString());
            stmt.setString(2, params.getRepresentation());
            stmt.setString(3, params.getPlayerId().toString());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Erreur de sauvegarde");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erreur sauvegarde player", e);
        }
        */

    }


    @Override
    public GameRecord getPlayer(String gameId) {

        GameRecord game = null;
        String sql = "SELECT * FROM games WHERE UUID = ?";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, game.gameId().toString());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Erreur de récupération");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }

    @Override
    public GameRecord deletePlayer(String gameId) {
        return null;
    }


}


