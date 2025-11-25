CREATE TABLE games
(
    UUID       VARCHAR(36) NOT NULL,
    board_size int         NOT NULL,
    name       VARCHAR(20) NOT NULL,
    PRIMARY KEY (UUID)
);

CREATE TABLE players
(
    id             int NOT NULL AUTO_INCREMENT,
    games_id       VARCHAR(36) NOT NULL,
    representation VARCHAR(1) NOT NULL,
    UUID           VARCHAR(36) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (games_id) REFERENCES games (UUID)

)