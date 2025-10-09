package Challenge;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    /*
    Returns true if the branch was added successfully. Else false.
     */
    public boolean addBranch(String name){
        if (findBranch(name)==null){
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    /*
    Returns true if the customer was added successfully. Else false.
     */
    public boolean addCustomer(String branch_name, String customer_name, double initial_transaction){
        Branch branch = findBranch(branch_name);
        if (branch!=null){
            return branch.newCustomer(customer_name, initial_transaction);
        }
        return false;
    }

    /*
    Returns true if the customer transaction was added successfully. Else false.
     */
    public boolean addCustomerTransaction(String branch_name, String customer_name, double transaction){
        Branch branch = findBranch(branch_name);
        if (branch!=null){
            return branch.addCustomerTransaction(customer_name, transaction);
        }
        return false;
    }

    /*
    Returns the branch if it exists. null otherwise.
     */
    private Branch findBranch(String branch_name){
        for (Branch branch: branches){
            if (branch.getName().equals(branch_name)){
                return branch;
            }
        }
        return null;
    }

    /*
    This method prints out the list of customers and returns true if the branch exists. False otherwise.
     */
    public boolean listCustomers(String branch_name, boolean print_transactions) {
        Branch branch = findBranch(branch_name);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch_name);
            ArrayList<Customer> customers = branch.getCustomers();
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.println("Customer: " + customer.getName() + "[" + (i + 1) + "]");
                if (print_transactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }
}
