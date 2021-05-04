package Concerete;

import java.time.LocalDate;

import Entities.Discount;
import Entities.Game;
import Interfaces.DiscountService;

public class DiscountManager implements DiscountService {

    @Override
    public Game UseDiscount(Game game, Discount discount) {
        if(discountContainsCategory(game.getCategory(), discount) && discountStillValid(discount)){
            Game discountedGame = new Game(game);
            discountedGame.setPrice(calculateDiscount(game.getPrice(), discount.getDiscountAmount()));
            System.out.println(discount.getDiscountAmount()*100+"% discount applied to " + game.getTitle());
            return discountedGame;
        }
        System.out.println("Discount cannot be applied to this game");
        return game;
    }

    @Override
    public Game UseDiscount(Game game, Discount[] discounts) {
        double totalDiscount = 0;
        for (Discount discount : discounts){
            if (discountContainsCategory(game.getCategory(), discount) && discountStillValid(discount)){
                totalDiscount += discount.getDiscountAmount();
            }
        }
        if(totalDiscount > 0){
            Game discountedGame = new Game(game);
            discountedGame.setPrice(calculateDiscount(discountedGame.getPrice(), totalDiscount));
            System.out.println(totalDiscount*100+"% discount applied to " + game.getTitle());
            return discountedGame;
        }
        

        System.out.println("Discounts cannot be applied to this game");
        return game;
    }

    private double calculateDiscount(double price,double totalDiscount){
        return price - (price * totalDiscount);
    }

    private boolean discountStillValid(Discount discount){
        return discount.getValidUntil().compareTo(LocalDate.now())>0;
    }

    private boolean discountContainsCategory(String category,Discount discount){

        String[] eligibleCategories = discount.getEligibleCategories();
        for (String cat : eligibleCategories){
            if (cat == category) {
                return true;
            }
        }
        return false;
    }
}
