package app.dao;


import app.dto.initialisation.PartyCreationDTO;
import app.dto.game.GameSaveDTO;
import app.models.record.GameRecord;
import jakarta.validation.Valid;

public interface TokenDAO {


    GameSaveDTO saveToken(@Valid PartyCreationDTO params);

    GameRecord getToken(String gameId);

    GameRecord deleteToken(String gameId);

}
