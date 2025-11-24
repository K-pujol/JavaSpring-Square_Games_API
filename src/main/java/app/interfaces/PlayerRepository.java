package app.interfaces;

import app.models.entities.Players;
import org.springframework.data.repository.CrudRepository;


public interface PlayerRepository extends CrudRepository<Players, Integer> {

}