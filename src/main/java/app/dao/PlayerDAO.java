package app.dao;


import app.dto.game.GameCreationDTO;
import app.dto.player.PlayerSaveDTO;
import app.models.record.GameRecord;
import jakarta.validation.Valid;

import java.util.UUID;

public interface PlayerDAO {


    PlayerSaveDTO savePlayer(@Valid PlayerSaveDTO params );

    GameRecord getPlayer(String gameId);

    GameRecord deletePlayer(String gameId);

}
