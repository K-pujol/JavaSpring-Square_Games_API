package app.interfaces.plugin;

import app.dto.game.GameCreationDTO;
import fr.le_campus_numerique.square_games.engine.Game;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Locale;
import java.util.UUID;

public interface GamePlugin {

    UUID getGameId();

    @NotBlank
    String getName(Locale locale);

    @NotNull
    Game createGame(GameCreationDTO params, Locale locale);

}