package Assignment4.src.Concrete;

import Assignment4.src.Interfaces.CustomerCheckService;
import Assignment4.src.Models.Customer;

public class CustomerCheckManager implements CustomerCheckService{

    @Override
    public boolean checkIfCustomerIsRealPerson(Customer customer) {
    
        //https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx
        return true;
    }
    
}
