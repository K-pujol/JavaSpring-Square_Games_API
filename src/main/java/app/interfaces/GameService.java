package app.interfaces;


import app.dto.GameCreationParams;

public interface GameService {
    String createGame(GameCreationParams params);

    void deleteGame(String gameId);
}
