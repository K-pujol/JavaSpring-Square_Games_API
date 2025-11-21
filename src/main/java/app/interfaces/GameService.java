package app.interfaces;


import app.dto.game.GameCreationDTO;

public interface GameService {

    String createGame(GameCreationDTO params);

    void deleteGame(String gameId);
}
