package app.dao.use;

import app.DBConnection;
import app.dto.game.GameResponseDTO;
import app.dto.initialisation.PartyCreationDTO;
import app.models.record.GameRecord;
import app.dao.GameDAO;
import app.dto.game.GameSaveDTO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Repository
public class JDBCGameDAO implements GameDAO {


    @Override
    public UUID saveGame(GameSaveDTO params) {
        String sql = "INSERT INTO games (UUID, name, board_size) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            UUID gameId = params.getId(); // ← Récupère l'UUID généré

            stmt.setString(1, gameId.toString());
            stmt.setString(2, params.getName());
            stmt.setInt(3, params.getBoardSize());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Erreur de sauvegarde");
            }

            return gameId;

        } catch (Exception e) {
            throw new RuntimeException("Erreur sauvegarde game", e);
        }
    }


    @Override
    public GameResponseDTO getGame(String gameId) {

        String sql = "SELECT g.UUID, g.name, g.board_size, " +
                "p.UUID, p.representation " +
                "FROM games g " +
                "JOIN players p ON g.UUID = p.games_id " +
                "WHERE g.UUID = ?";

        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, gameId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new GameResponseDTO(
                            UUID.fromString(rs.getString("UUID")),
                            rs.getString("name"),
                            rs.getInt("board_size"),
                            rs.getString("representation")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GameRecord deleteGame(String gameId) {
        return null;
    }


    @Override
    public GameSaveDTO updateGame(GameSaveDTO params) {
        return null;
    }


}


