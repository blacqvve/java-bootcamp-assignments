import java.time.LocalDate;

import Abstract.BaseUserManager;
import Adapters.MernisKPSAdapter;
import Concerete.DiscountManager;
import Concerete.GameManager;
import Concerete.IndividualUserManager;
import Concerete.SaleManager;
import Concerete.UserManager;
import Concerete.UserValidationManager;
import Entities.DeveloperUser;
import Entities.Discount;
import Entities.Game;
import Entities.IndividualUser;
import Entities.PublisherUser;
import Entities.User;
import Interfaces.PersonValidityService;

public class Main {
    public static void main(String[] args){

        IndividualUser jane = new IndividualUser(1, "jane@gmail.com", "Jane", "Doe", LocalDate.of(1986,1,23), "1231412411");

        DeveloperUser ludeonStudios = new DeveloperUser(2, "info@ludeonstuios.com", "Ludeon Studios");

        User valve = new PublisherUser(3, "info@valve.com", "Valve Corporation");

        PersonValidityService<IndividualUser> personValidityService = new MernisKPSAdapter();

        BaseUserManager<IndividualUser> invidualUserManager = new IndividualUserManager(personValidityService);

        invidualUserManager.add(jane);

        jane.setName("John");

        invidualUserManager.update(jane);
        
        BaseUserManager<User> userManager = new UserManager();
        
        userManager.add(valve);

        valve.setEmail("contact@valve.com");

        userManager.update(valve);

        Game halfLife = new Game(1, "Half-Life", valve, valve, 20, "FPS");

        Game portal = new Game(2,"Portal",valve,valve,30,"FPS");

        Game rimworld = new Game(3,"Rimworld",ludeonStudios,ludeonStudios,60,"Simulation");

        ludeonStudios.setGames(new Game[]{rimworld});

        GameManager gameManager = new GameManager();

        gameManager.add(new Game[]{halfLife,portal,rimworld});

        portal.setTitle("Portal 2");

        gameManager.update(portal);

        gameManager.delete(portal);

        Discount simulationDiscount = new Discount(1, LocalDate.of(2022, 1, 1), 0.3, new String[]{"Simulation"});

        DiscountManager discountManager = new DiscountManager();

        Game discountedGame = discountManager.UseDiscount(rimworld, simulationDiscount);

        SaleManager saleManager = new SaleManager();

        saleManager.sale(jane, discountedGame);

    }
}
