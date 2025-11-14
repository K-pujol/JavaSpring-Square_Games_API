package app.interfaces;

import java.util.ArrayList;
import java.util.Collection;

public interface GameCatalog {
    public Collection<String> collection = new ArrayList<>();

    Collection<String> getGameIdentifiers();
}
