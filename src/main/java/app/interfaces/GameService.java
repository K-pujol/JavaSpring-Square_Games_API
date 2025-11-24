package app.interfaces;


import app.dto.initialisation.PartyCreationDTO;

public interface GameService {

    String createGame(PartyCreationDTO params);

    void deleteGame(String gameId);
}
