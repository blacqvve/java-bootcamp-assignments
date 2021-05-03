package Assignment4.src.Concrete;

import Assignment4.src.Abstract.BaseCustomerManager;
import Assignment4.src.Interfaces.CustomerCheckService;
import Assignment4.src.Models.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {
    
    private CustomerCheckService customerCheckService;
    
    public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
        this.customerCheckService = customerCheckService;
    }

    @Override
    public void save(Customer customer) {

        //check mernis confirmation here 
        if (customerCheckService.checkIfCustomerIsRealPerson(customer)){
            super.save(customer);
        }
        else{
           
        }
        
    }

    
}
