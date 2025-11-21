package app.models.record;

import java.util.UUID;

public record GameRecord(String name,
                         int boardSize,
                         UUID gameId,
                         String representation {

}
