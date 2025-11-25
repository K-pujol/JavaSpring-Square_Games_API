package app.dto.initialisation;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PartyCreationDTO {

    @NotBlank
    private String gameName;

    @Min(3)
    @Max(10)
    private int boardSize;

    @NotBlank
    @Size(min = 1, max = 1)
    private String playerOneRepresentation;

    @NotBlank
    @Size(min = 1, max = 1)
    private String playerTwoRepresentation;
}
