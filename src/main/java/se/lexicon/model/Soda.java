package se.lexicon.model;



public class Soda implements Product {

    private final int Id;
    private String productName;
    private double price;

    public Soda(String productName, double price) {
        this.Id= Product.nextId();
        setProductName(productName);
        setPrice(price);
    }

    @Override
    public String examine() {
        return "Soda{" +
                "Id=" + Id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }



    @Override
    public String use() {
        return getProductName()+ " is used.";
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
    }


}

