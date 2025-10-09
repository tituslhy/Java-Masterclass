package Challenge;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initial_transaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initial_transaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction){
        transactions.add(transaction); //autoboxing occurs here
    }
}
