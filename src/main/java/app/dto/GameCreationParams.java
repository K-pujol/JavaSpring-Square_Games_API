package app.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameCreationParams {

    @NotBlank
    @Pattern(regexp = "TicTacToe|ConnectFour|Taquin", message = "{gameCreationParams.name.Pattern}")
    String name;

    @Min(value = 1, message = "Nombre de joueurs minimum 1")
    @Max(value = 1, message = "Nombre de joueurs maximum 1")
    int playerCount;

    @Min(value = 3, message = "Taille du plateau minimum 1")
    @Max(value = 8, message = "Taille du plateau maximum 8")
    int boardSize;

}
