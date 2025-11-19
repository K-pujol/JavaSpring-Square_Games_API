package app.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.Set;
import java.util.UUID;

@Data
public class GameCreationParams {

    @NotBlank
    @Pattern(regexp = "TicTacToe|ConnectFour|Taquin", message = "${gameCreationParams.name.Pattern}")
    private String name;

    @Min(value = 1, message = "${gameCreationParams.playerCount.Min}")
    @Max(value = 100, message = "${gameCreationParams.playerCount.Max}")
    private int playerCount;

    @Min(value = 3, message = "{$gameCreationParams.boardSize.Min}")
    @Max(value = 8, message = "${gameCreationParams.boardSize.Max}")
    private int boardSize;

    UUID id;

    Set<UUID> playerIds;
}
