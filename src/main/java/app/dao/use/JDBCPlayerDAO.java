package app.dao.use;

import app.DBConnection;
import app.dao.PlayerDAO;
import app.dto.game.GameCreationDTO;
import app.dto.player.PlayerSaveDTO;
import app.models.record.GameRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class JDBCPlayerDAO implements PlayerDAO {


    @Override
    public PlayerSaveDTO savePlayer(PlayerSaveDTO params) {

        String sql = "INSERT INTO players (UUID, games_id,representation) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            CreatePlayer(params, stmt);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Erreur de sauvegarde");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savePlayer;
    }

    private static void CreatePlayer(PlayerSaveDTO params, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, params.getPlayer().toString());
        stmt.setString(2, params.getId().toString());
        stmt.setString(3, params.getRepresentation());
        stmt.executeUpdate();


        stmt.setString(1, params.getPlayer().toString());
        stmt.setString(2, params.getId().toString());
        stmt.setString(3, params.getRepresentation());
        stmt.executeUpdate();
    }


    @Override
    public GameRecord getPlayer(String gameId) {

        GameRecord game = null;
        String sql = "SELECT * INTO games WHERE UUID = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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


