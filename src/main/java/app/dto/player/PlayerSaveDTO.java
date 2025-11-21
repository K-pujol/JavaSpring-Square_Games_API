package app.dto.player;

import app.dto.game.GameCreationDTO;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class PlayerSaveDTO {

    public PlayerSaveDTO(String representation) {
        this.id = UUID.randomUUID();
        this.player = UUID.randomUUID();
        this.representation = representation;
    }

    @NotBlank
    private String representation;

    @NotBlank
    private UUID player;

    @NotNull
    UUID id;

}
