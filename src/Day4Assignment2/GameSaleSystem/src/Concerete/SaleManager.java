package Concerete;

import Entities.Game;
import Entities.User;
import Interfaces.SaleService;

public class SaleManager implements SaleService {

    @Override
    public void sale(User buyer, Game game) {
        System.out.println("User with " + buyer.getUserId() +" id purchased " + game.getTitle());
    }

    @Override
    public void sale(User buyer, Game[] games) {
        StringBuilder sb = new StringBuilder();

        for (Game game : games) {
            sb.append(game.getTitle());
        }

        System.out.println("User with "+ buyer.getUserId() + " id purchased" + sb.toString());
    }
    
}
