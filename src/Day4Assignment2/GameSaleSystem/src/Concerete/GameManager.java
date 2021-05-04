package Concerete;

import Entities.Game;
import Interfaces.GameService;

public class GameManager implements GameService {

    public void add(Game[] games){
        for (Game game:games){
            add(game);
        }
    }
    @Override
    public void add(Game game) {
        System.out.println("Game added. Game title:" + game.getTitle());
    }

    @Override
    public void update(Game game) {
        System.out.println("Game title updated. New title is:" + game.getTitle());
    }

    @Override
    public void delete(Game game) {
        System.out.println("Game deleted. Game Title: " + game.getTitle());
    }
    
}
