public class Galaxy extends ProductForSale{
    public Galaxy(double price) {
        super("Galaxy S25", price, "The Galaxy S25 is the latest Samsung phone launch");
    }

    @Override
    public void showDetails() {
        System.out.printf("%s:%s Price: %.2f", type, description, price);
    }
}