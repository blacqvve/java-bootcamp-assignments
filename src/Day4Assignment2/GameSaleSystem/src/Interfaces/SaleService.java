package Interfaces;

import Entities.Game;
import Entities.User;

public interface SaleService {
    
    void sale(User buyer, Game game);
    
    void sale(User buyer, Game[] games);
}
