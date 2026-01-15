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
class Expense {
    private String name;
    private double price;
    
    //Constructor
    public Expense(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    //Getters
    public String getName(){ return name;}
    public double getPrice(){return price;}
}
public class SpendingTracker{
    
    public static void main(String[] args){
        //User input
        Scanner input = new Scanner(System.in);
        
        //Using ArrayList to store objects
        ArrayList<Expense> receipt = new ArrayList<>();
        
        System.out.println("Enter starting amount: ");
        double initialBalance = input.nextDouble();
        input.nextLine();
        
        //Using loops
        //(while loop)
        while (true){
            System.out.println("Current Balance: Php " + calculateRemaining(initialBalance, receipt));
            System.out.println("Enter item name (or type 'done' to end): ");
            String itemName = input.nextLine();
            
            if (itemName.equalsIgnoreCase("done")){
                break;
            }
            
            System.out.println("Enter price of " + itemName + ": ");
            double itemPrice = input.nextDouble();
            input.nextLine();
            
            //Creating an object and adding it to the list
            receipt.add(new Expense(itemName, itemPrice));
            System.out.println(itemName + " added to cart.");
        }
        
        displayFinalReceipt(receipt, initialBalance);
        
        input.close();
    }
        //COmputations implemented using methods.
        //calculates the remaining balance
    public static double calculateRemaining(double start, ArrayList<Expense>list){
        double totalSpent = 0;
        for (Expense e : list){
            totalSpent += e.getPrice();
        }
        return start - totalSpent;
    }
    //Computations implemented using methods
    public static void displayFinalReceipt(ArrayList<Expense>list, double startBalance) {
        System.out.println("---FINAL RECEIPT---");
        
        //Using a loop to iterate throughthe array/List.
        for (Expense e : list) {
            System.out.println("- " + e.getName()+ ": Php " + e.getPrice());
        }
        
        double finalBal = calculateRemaining(startBalance, list);
        System.out.println("---------------------");
        System.out.println("Final balance: Php " + finalBal);
        
        if (finalBal < 0){
            System.out.println("Warning!: You have exceeded your budget!");
        }
        else {
            System.out.println("Budget status: Within limits.");
        }
    }
}