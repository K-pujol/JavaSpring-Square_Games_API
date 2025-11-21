package app.dto.game;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.*;

@Data
public class GameResponseDTO {

    @NotNull
    private UUID id;

    @NotBlank
    @Pattern(regexp = "TicTacToe|ConnectFour|Taquin")
    private String name;

    @Min(value = 3)
    @Max(value = 8)
    private int boardSize;

    @NotNull
    private Map<UUID, String> players = new HashMap<>();

    //  vide
    public GameResponseDTO() {}

    public GameResponseDTO(UUID id, String name, int boardSize) {
        this.id = id;
        this.name = name;
        this.boardSize = boardSize;
    }
    public void addPlayer(UUID playerId, String representation) {
        players.put(playerId, representation);
    }

    public String getPlayerRepresentation(UUID playerId) {
        return players.get(playerId);
    }
}
