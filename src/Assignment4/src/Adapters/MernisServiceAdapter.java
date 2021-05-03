package Assignment4.src.Adapters;

import Assignment4.src.Interfaces.CustomerCheckService;
import Assignment4.src.Models.Customer;

public class MernisServiceAdapter implements CustomerCheckService {

    @Override
    public boolean checkIfCustomerIsRealPerson(Customer customer) {

        //connection and verification with MernisAPI
        return true;
    }
    
}
