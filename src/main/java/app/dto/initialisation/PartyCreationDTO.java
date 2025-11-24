package app.dto.initialisation;

import app.models.entities.Games;
import app.models.entities.Players;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PartyCreationDTO {

    private Games games;
    private Players player_one;
    private Players player_two;

}
