/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.spendingtracker;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author ACER
 */
public class SpendingTracker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        // Two lists: one for names, one for prices
        ArrayList<String> receipt = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        System.out.print("Enter starting amount: ");
        double balance = input.nextDouble();
        input.nextLine(); 

        while (true) {
            System.out.println("\nCurrent balance: Php " + balance);
            System.out.print("Enter item name (or type 'done'): ");
            String item = input.nextLine();

            if (item.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter price of " + item + ": ");
            double price = input.nextDouble();
            input.nextLine(); 

            // Logic: subtract from balance and save to BOTH lists
            balance = balance - price;
            receipt.add(item); 
            prices.add(price);

            System.out.println(item + " added to cart.");
        }

        // Final Receipt Section
        System.out.println("\n--- FINAL RECEIPT ---");
        for (int i = 0; i < receipt.size(); i++) {
            // Get item from list 1 and price from list 2 using the same index 'i'
            System.out.println("- " + receipt.get(i) + ": Php" + prices.get(i));
        }
        
        System.out.println("---------------------");
        System.out.println("Final balance: Php" + balance);
        input.close();
    }
}
