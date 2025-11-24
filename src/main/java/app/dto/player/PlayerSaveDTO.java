package app.dto.player;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class PlayerSaveDTO {

    public PlayerSaveDTO(String representation, UUID gameId) {
        this.gameId = gameId;
        this.playerId = UUID.randomUUID();
        this.representation = representation;
    }

    @NotBlank
    private String representation;

    @NotBlank
    private UUID playerId;

    @NotBlank
    private UUID gameId;

}
