package app.dto.initialisation;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PartyCreationDTO {

    @NotBlank
    @Pattern(regexp = "TicTacToe|ConnectFour|Taquin", message = "${gameCreationParams.name.Pattern}")
    private String name;

    @NotBlank
    private String playerOneRepresentation;

    @NotBlank
    private String playerTwoRepresentation;

    @Min(value = 3, message = "{$gameCreationParams.boardSize.Min}")
    @Max(value = 8, message = "${gameCreationParams.boardSize.Max}")
    private int boardSize;

}
