class BookProduct extends Product {
    private String author;
    private String publisher;

    public BookProduct(int productId, String name, float price, String author, String publisher) {
        super(productId, name, price);
        this.author = author;
        this.publisher = publisher;
    }

    // Getters and setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "BookProduct{" +
                "author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                "} " + super.toString();
    }
}