package app.interfaces;

import app.models.entities.Games;
import org.springframework.data.repository.CrudRepository;


public interface GameRepository extends CrudRepository<Games, String> {

}