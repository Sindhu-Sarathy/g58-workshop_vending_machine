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

        Product requested=null;

        // To print all products
        System.out.println("All products: ");
        System.out.println(Arrays.toString(vendingMachine.getProducts()));

        System.out.println("---------------------------------------------------------");
        //To get a product description
        System.out.println("Product Description");
        System.out.println(vendingMachine.getDescription(0));
        System.out.println();

        //add currency
        vendingMachine.addCurrency(Currency.TEN);
        vendingMachine.addCurrency(Currency.TEN);
        vendingMachine.addCurrency(Currency.FIVE);

        //get balance
        System.out.println();
        System.out.println("The Total amount is: ");
        System.out.println(vendingMachine.getBalance());

        System.out.println();
//        //request something not available
//        try{
//            requested= vendingMachine.request(3);
//            System.out.println("The product is not available.");
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }

        //request something expensive
        try{
            requested= vendingMachine.request(1);
            System.out.println("You have brought: "+requested.getProductName());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        //Getting balance after buying the products
        System.out.println("The Balance amount: ");
        System.out.println(vendingMachine.getBalance());

        //Ending session
        System.out.println();

        int change= vendingMachine.endSession();
        System.out.println("The Session ended.Please find the remaining amount:"+change);

        //getting balance after ending session
        System.out.println();
        System.out.println("The Current balance is: ");
        System.out.println(vendingMachine.getBalance());


        //Used Products
        System.out.println("The Used Products: ");

        if(requested!=null){
            System.out.println(requested.use());
        }
}




}
