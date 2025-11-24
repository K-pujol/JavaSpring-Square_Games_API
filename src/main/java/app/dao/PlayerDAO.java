package app.dao;


import app.dto.initialisation.PartyCreationDTO;

import app.dto.player.PlayerSaveDTO;
import app.models.record.GameRecord;
import jakarta.validation.Valid;

public interface PlayerDAO {


    void savePlayer(@Valid PlayerSaveDTO params );

    GameRecord getPlayer(String gameId);

    GameRecord deletePlayer(String gameId);

}
