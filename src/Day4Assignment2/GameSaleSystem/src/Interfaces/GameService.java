package Interfaces;

import Entities.Game;

public interface GameService {
    
    void add(Game game);
    
    void add(Game[] games);

    void update(Game game);

    void delete(Game game);
}
