package app.dao.use;

import app.DBConnection;
import app.dto.game.GameResponseDTO;
import app.models.record.GameRecord;
import app.dao.GameDAO;
import app.dto.game.GameCreationDTO;
import app.dto.game.GameSaveDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class JDBCGameDAO implements GameDAO {


    @Override
    public GameSaveDTO saveGame(GameCreationDTO params) {

        GameSaveDTO savedGame = new GameSaveDTO(params);

        String sql = "INSERT INTO games (UUID, name, board_size) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, savedGame.getId().toString());
            stmt.setString(2, savedGame.getName());
            stmt.setInt(3, savedGame.getBoardSize());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Erreur de sauvegarde");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedGame;
    }


    @Override
    public GameResponseDTO  getGame(String gameId) {

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
                            rs.getInt("board_size"),
                            rs.getString("name"),
                            rs.getString("representation")

                            );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return game;
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


