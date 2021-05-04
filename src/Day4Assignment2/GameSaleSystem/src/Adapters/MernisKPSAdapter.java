package Adapters;

import Entities.IndividualUser;
import Interfaces.PersonValidityService;

public class MernisKPSAdapter implements PersonValidityService<IndividualUser> {

    @Override
    public boolean checkPersonValidity(IndividualUser user) {
        System.out.println("Person validated from mernis system. User:" + user);
        return true;
    }
    
}
