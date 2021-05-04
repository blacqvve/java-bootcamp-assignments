package Concerete;

import Abstract.BaseUserManager;
import Entities.IndividualUser;
import Interfaces.PersonValidityService;

public class IndividualUserManager extends BaseUserManager<IndividualUser>{

    private PersonValidityService<IndividualUser> personValidityService;

    public IndividualUserManager(PersonValidityService<IndividualUser> personValidityService) {
        this.personValidityService = personValidityService;
    }

    @Override
    public void add(IndividualUser user){
       if(personValidityService.checkPersonValidity(user)){
           super.add(user);
       }
       else{
           System.out.println("User is not a valid person");
       }
    }
    @Override
    public void update(IndividualUser user) {
        System.out.println("User name updated. New name is: "+ user.getFullName());
        super.update(user);
    }

    @Override
    public void add(IndividualUser[] users) {
        for(IndividualUser user:users){
            add(user);
        }
    }
    
}
