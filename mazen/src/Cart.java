import java.util.Arrays;

class Cart {
    private int customerId;
    private int nProducts;
    private Product[] products;
    int numbers =0;

    public Cart(int customerId, int nProducts) {
        this.customerId = Math.abs(customerId);
        this.nProducts = Math.abs(nProducts);
        this.products = new Product[nProducts];
    }

    // Getters and setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getnProducts() {
        return nProducts;
    }

    public void setnProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void addProduct(Product product) {

        products[numbers] = product;
        numbers++;

    }

    public void removeProduct(Product product) {
        for (int i = 0; i < numbers; i++) {
            if (products[i].equals(product)) {
                for (int j = i; j < numbers - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[numbers - 1] = null;
                numbers--;
                break;
            }
        }
    }

    public float calculatePrice() {
        float totalPrice = 0;
        for (int i = 0; i < numbers; i++) {
            totalPrice += products[i].getPrice();
        }
        return totalPrice;
    }

    public void placeOrder() {
        // Assume placing order involves clearing the cart
        Arrays.fill(products, null);
        nProducts = 0;
    }
}