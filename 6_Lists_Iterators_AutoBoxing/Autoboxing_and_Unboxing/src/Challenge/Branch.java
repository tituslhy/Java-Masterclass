package Challenge;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    /*
    Returns true if the customer was added successfully. false otherwise.
     */
    public boolean newCustomer(String customer_name, double initial_transaction){
        Customer potentialCustomer = findCustomer(customer_name);
        if (findCustomer(customer_name) == null) {
            Customer newCustomer = new Customer(customer_name, initial_transaction);
            customers.add(newCustomer);
            return true;
        }
        return false;
    }

    /*
    Returns true if the customer transaction was added successfully. Else false.
     */
    public boolean addCustomerTransaction(String customer_name, double transaction){
        Customer customer = findCustomer(customer_name);
        if (customer!=null){
            customer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    /*
    Returns customer if name is found. Else returns null.
     */
    private Customer findCustomer(String customer_name){
        for (Customer customer: customers){
            if (customer.getName().equals(customer_name)){
                return customer;
            }
        }
        return null;
    }
}
