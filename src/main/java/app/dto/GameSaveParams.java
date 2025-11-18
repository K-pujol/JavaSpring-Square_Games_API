package app.dto;

import fr.le_campus_numerique.square_games.engine.CellPosition;
import fr.le_campus_numerique.square_games.engine.Token;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Data
public class GameSaveParams {

    @NotBlank
    @Pattern(regexp = "TicTacToe|ConnectFour|Taquin", message = "${gameCreationParams.name.Pattern}")
     String name;

    @Min(value = 1, message = "${gameCreationParams.playerCount.Min}")
    @Max(value = 100, message = "${gameCreationParams.playerCount.Max}")
     int playerCount;

    @Min(value = 3, message = "{$gameCreationParams.boardSize.Min}")
    @Max(value = 8, message = "${gameCreationParams.boardSize.Max}")
     int boardSize;

    @NotNull
    UUID id;

    @NotNull
    Set<UUID> playerIds;

    @NotNull
    Map<CellPosition, Token> board;

}
