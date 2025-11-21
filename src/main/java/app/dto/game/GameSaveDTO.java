package app.dto.game;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.UUID;

@Data
public class GameSaveDTO {

    public GameSaveDTO(GameCreationDTO params) {
        this.id = UUID.randomUUID();
        this.name = params.getName();
        this.boardSize = params.getBoardSize();
    }

    @NotBlank
    @Pattern(regexp = "TicTacToe|ConnectFour|Taquin", message = "${gameCreationParams.name.Pattern}")
    String name;

    @Min(value = 3, message = "{$gameCreationParams.boardSize.Min}")
    @Max(value = 8, message = "${gameCreationParams.boardSize.Max}")
    int boardSize;

    @NotNull
    UUID id;
}
