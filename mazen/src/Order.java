class Order {
    private int customerId;
    private int orderId;
    private Product[] products;
    private float totalPrice;
    private int numbers;

    public Order(int customerId, int orderId, Product[] products,int numbers) {
        this.customerId = Math.abs(customerId);
        this.orderId = Math.abs(orderId);
        this.products = products;
        this.totalPrice = calculateTotalPrice();
        this.numbers=numbers;
    }

    // Getters and setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = Math.abs(orderId);
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
        this.totalPrice = calculateTotalPrice();
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    private float calculateTotalPrice() {
        float totalPrice = 0;
        for (int i = 0; i < numbers; i++) {
            totalPrice+=products[i].getPrice();
        }
        return totalPrice;
    }

    public void printOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + ", Price: " + product.getPrice());
        }
        System.out.println("Total Price: " + totalPrice);
    }
    public  String getOrderInfo(){
        String b="";
        for (int i=0;i<numbers;i++) {
            b+="\n- " + products[i].getName() + ", Price: " + products[i].getPrice();
        }
        String a="Order ID : %d \nCustomer ID : %d\n products :".formatted(orderId,customerId);
        a+=b;
        a+="\nTotal Price: " + calculateTotalPrice();
        return a;
    }
}
