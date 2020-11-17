/* Alex Ortega
 * The Tester class is responsible to obtain orders from the orders.txt file
 * Each Order object will be placed in the AmazonDotCom shopping cart 
*/

import java.io.*;
import java.util.Scanner;

public class Tester{
  public static void main(String [] args)throws IOException{
    
    Scanner       read           = new Scanner(new File("orders.txt"));
    Order         order          = new Order();
    AmazonDotCom  shoppingCart   = new AmazonDotCom();
    String        lineFromFile;
    
    while(read.hasNext()){
      
      lineFromFile = read.nextLine();
      order = new Order(lineFromFile);
      shoppingCart.add(order);
    }
    
    System.out.println("Original: ");
    shoppingCart.print();
    System.out.println("Sorted: ");
    shoppingCart.sortList();
    
    System.out.println("\nMost expensive order: "+ shoppingCart.findMostExpensiveOrder());
    System.out.println("Most cheapset order: "+ shoppingCart.findMostCheapestOrder()+"\n");
    System.out.print("Will check to see if Order Z is in the shopping cart: ");
    System.out.println(shoppingCart.findOrder(new Order("Z", 9.9, 1)));
    System.out.print("How many times does Order S and price appear in the shoppingCart? ");
    System.out.println(shoppingCart.countOccurrences(new Order("S", 8.54, 1)));
    read.close();
  }  
}