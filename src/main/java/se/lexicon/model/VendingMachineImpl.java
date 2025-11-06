package se.lexicon.model;

import java.util.Arrays;

public class VendingMachineImpl implements VendingMachine{
    private Product[] products;
    private int depositPool;

    public VendingMachineImpl(Product[] products) {
        this.products = products;
    }

    @Override
    public void addCurrency(Currency amount) {
        depositPool += amount.getValue();
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
      int indexFoundAt=1;
      for(Product product:products){
          if(product.getId()==id){
              indexFoundAt=id;
              break;
          }
      }
      //If the id is not found
      if(indexFoundAt==-1) throw new RuntimeException("The product was not found.");
      //if the id is found
        Product foundProduct=products[indexFoundAt];
        if(getBalance()>foundProduct.getPrice()) {
            depositPool = -(int) Math.ceil(foundProduct.getPrice());

            Product[] newProducts = new Product[products.length - 1];
            for (int i = 0, j = 0; i < products.length; i++) {
                if (products[i] != foundProduct) {
                    newProducts[j] = products[i];
                    j++;
                }
            }

            products = newProducts;

            return foundProduct;
        }
        else{
            throw new RuntimeException("Insufficient balance.");
        }
    }

    @Override
    public int endSession() {
        int temp=depositPool;
        depositPool=0;
        return temp;
    }

    @Override
    public String getDescription(int id) {

        for(Product product:products){
            if(product.getId()==id){
                return product.examine();
            }

        }
        throw new RuntimeException("Product not found");
    }

    @Override
    public String[] getProducts() {
        String[] description=new String[products.length];
        for (int i = 0; i < products.length; i++) {
            description[i] = products[i].examine();
        }

        return description;
    }
}
