package Assignment4.src.Abstract;

import Assignment4.src.Interfaces.CustomerService;
import Assignment4.src.Models.Customer;

public abstract class BaseCustomerManager implements CustomerService{

    public void save(Customer customer){
        System.out.println(customer.getFullName() + " added to database");
    }

}
