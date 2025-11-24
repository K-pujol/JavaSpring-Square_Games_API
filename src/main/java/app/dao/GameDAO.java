package app.dao;

import app.dto.game.GameResponseDTO;
import app.dto.initialisation.PartyCreationDTO;
import app.dto.player.PlayerSaveDTO;
import app.models.record.GameRecord;
import app.dto.game.GameSaveDTO;
import jakarta.validation.Valid;

import java.util.UUID;

public interface GameDAO {

    UUID saveGame(GameSaveDTO params);

    GameSaveDTO updateGame(@Valid GameSaveDTO params);

    GameResponseDTO getGame(String gameId);

    GameRecord deleteGame(String gameId);

}
