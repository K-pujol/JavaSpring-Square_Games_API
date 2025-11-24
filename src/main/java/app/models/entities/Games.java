package app.models.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Games {

    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String UUID;

    private int board_size;

    private String name;

}

