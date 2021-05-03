package Assignment4.src;

import java.time.LocalDate;

import Assignment4.src.Abstract.BaseCustomerManager;
import Assignment4.src.Concrete.CustomerCheckManager;
import Assignment4.src.Concrete.StarbucksCustomerManager;
import Assignment4.src.Models.Customer;

class Main{
    public static void main(String[] args) {

        BaseCustomerManager customerManager = new StarbucksCustomerManager(new CustomerCheckManager());

        customerManager.save(new Customer(1,"Jane","Doe",LocalDate.of(1987,2,14),"12314124"));

        customerManager.save(new Customer(2,"John","Doe",LocalDate.of(1987,2,5),"2312321"));

    }
}