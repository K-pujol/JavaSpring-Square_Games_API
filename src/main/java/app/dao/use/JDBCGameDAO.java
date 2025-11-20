package app.dao.use;

import app.DBConnection;
import app.GameRecord;
import app.dao.GameDAO;
import app.dto.GameCreationParams;
import app.dto.GameSaveParams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class JDBCGameDAO implements GameDAO {


    @Override
    public GameSaveParams saveGame(GameSaveParams params) {
        String sql = "INSERT INTO games (UUID, name, playerCount, boardSize) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, params.getId().toString());
            stmt.setString(2, params.getName());
            stmt.setInt(3, params.getPlayerCount());
            stmt.setInt(4, params.getBoardSize());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Erreur de sauvegarde");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }



    @Override
    public GameSaveParams updateGame(GameSaveParams params) {
        return null;
    }

    @Override
    public GameRecord getGame(UUID gameId) {
        return null;
    }

    @Override
    public GameRecord deleteGame(UUID gameId) {
        return null;
    }
}


