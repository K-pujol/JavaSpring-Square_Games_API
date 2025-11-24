package app.models.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "games_id", referencedColumnName = "UUID")
    private Games game;

    private String representation;



    @PrePersist
    public void prePersist() {
        if (UUID == null) {
            UUID = java.util.UUID.randomUUID().toString();
        }
    }

    private String UUID;
}