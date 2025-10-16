public class iPhone extends ProductForSale{
    public iPhone(double price) {
        super("iPhone 17", price, "The iPhone 17 is the latest iPhone launch");
    }

    @Override
    public void showDetails() {
        System.out.printf("%s:%s Price: %.2f", type, description, price);
        System.out.println();
    }
}