package app;

import java.util.Set;
import java.util.UUID;

public record GameRecord(String name, int playerCount, int boardSize, UUID gameId, Set<UUID> playerIds) {

}
