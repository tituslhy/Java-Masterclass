public class OrderItem {
    private ProductForSale product;
    private int quantity;

    public OrderItem(ProductForSale product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public ProductForSale getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
