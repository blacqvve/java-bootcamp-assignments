package Interfaces;

import Entities.Discount;
import Entities.Game;

public interface DiscountService {
    Game UseDiscount(Game game,Discount discount);

    Game UseDiscount(Game game, Discount[] discounts);
}
