import java.util.ArrayList;

record Order(int quantity, ProductForSale product){}

public class Store {
    private static ArrayList<ProductForSale> productsForSale = new ArrayList<>();

    public static void main(String[] args) {
        productsForSale.add(new iPhone(1700));
        productsForSale.add(new Galaxy(1300));
        listProducts();

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<Order>();
        addItemToOrder(order1, 1,2);
        addItemToOrder(order1, 0,1);
        printOrder(order1);
    }

    public static void listProducts(){
        for (var item : productsForSale){
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    /*
    Method to add item to order
     */
    public static void addItemToOrder(ArrayList<Order> order, int orderIndex, int quantity){
        order.add(new Order(quantity, productsForSale.get(orderIndex)));
    }

    /*
    Method to print sales receipt
     */
    public static void printOrder(ArrayList<Order> order){
        double salesTotal = 0;
        for (var item : order){
            item.product().printPricedItem(item.quantity());
            salesTotal += item.product().getSalesPrice(item.quantity());
        }
        System.out.printf("Sales total = $%6.2f %n", salesTotal);
    }
}

