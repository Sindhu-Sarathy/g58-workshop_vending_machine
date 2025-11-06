package se.lexicon;

import se.lexicon.model.*;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[]args){
        Product soda=new Soda("Coco Cola",25);
        Product chips=new Chips("Lays",10);
        Product chocolate=new Chocolates("Sneakers",30);

        Product[] products= new Product[]{soda,chips,chocolate};

        VendingMachineImpl vendingMachine=new VendingMachineImpl(products);

        // To print all products
        System.out.println(Arrays.toString(vendingMachine.getProducts()));

        //To get a product description
        System.out.println(vendingMachine.getDescription(2));

        //add currency
        vendingMachine.addCurrency(Currency.TEN);
        vendingMachine.addCurrency(Currency.TEN);
        vendingMachine.addCurrency(Currency.FIVE);

        //get balance
        System.out.println(vendingMachine.getBalance());

        //request something not expensive
        try{
            Product requested= vendingMachine.request(1);
            System.out.println("You have brought: "+requested.getProductName());
        } catch (RuntimeException e) {
            System.out.println("Too Expensive");
        }

        //request something expensive
        try{
            Product requested= vendingMachine.request(2);
            System.out.println("You have brought: "+requested.getProductName());
        } catch (RuntimeException e) {
            System.out.println("Too Expensive");
        }

        //Getting balance after buying the products
        System.out.println(vendingMachine.getBalance());

        //Ending session
        vendingMachine.endSession();

        //getting balance after ending session
        System.out.println(vendingMachine.getBalance());
}




}
