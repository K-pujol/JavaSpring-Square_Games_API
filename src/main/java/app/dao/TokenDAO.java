package app.dao;


import app.dto.game.GameCreationDTO;
import app.dto.game.GameSaveDTO;
import app.models.record.GameRecord;
import jakarta.validation.Valid;

public interface TokenDAO {


    GameSaveDTO saveToken(@Valid GameCreationDTO params);

    GameRecord getToken(String gameId);

    GameRecord deleteToken(String gameId);

}
