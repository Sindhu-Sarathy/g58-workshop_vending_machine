package se.lexicon.model;

public class Chips implements Product {

    private final int Id;
    private String productName;
    private double price;

    public Chips(String productName, double price) {
        this.Id= Product.SEQUENCER.getAndIncrement();
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String examine() {
        return "Chips{" +
                "Id=" + Id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }



    @Override
    public String use() {
        return "The chips are used";
    }

    public int getId() {
        return Id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
