package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    double balance;
    double remainingBalance = balance;
    Inventory inventory = new Inventory();
    List<Edible> items = inventory.getVmItems();
    VendingLog vendingLog = new VendingLog();


    public double feedMoney(double moneyGiven) {
        balance += moneyGiven;
        //System.out.println("Current Balance is: " + "$" + balance);
        System.out.printf("Current Balance is: %.2f",balance);


        String feedMoneyMessage = "FEED MONEY: " + "$" +moneyGiven + " " + "$" + balance;
        vendingLog.logTransaction(feedMoneyMessage);
        return balance;
    }

    public boolean isValidSelection(String userRowSelection) {
        boolean isValidSelection = false;
        for (Edible item : items) {
            if (userRowSelection.equals(item.getRow())) {
                isValidSelection = true;
            }

        }
        return isValidSelection;
    }

    public double getBalance() {
        return balance;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public ChangeMaker makeChange() {
        ChangeMaker makeChange = new ChangeMaker(remainingBalance);
        balance = balance - remainingBalance;

        String giveChangeMessage = "GIVE CHANGE: " +" "+ "$"+ remainingBalance +" "+ "$"+ balance;
        vendingLog.logTransaction(giveChangeMessage);

        return makeChange;
    }


    public String purchaseItem(String userRowSelection) {

        int itemInventory = 0;
        if (!isValidSelection(userRowSelection)) {
            System.out.println("Invalid Selection. Please try again.");
        } else {
            try {
                for (Edible item : items) {
                    if (userRowSelection.equals(item.getRow())) {
                        if (item.getInventory() > 0) {
                            if (item.getPrice() > balance) {
                                System.out.println("Insufficient balance. Please add money");
                                break;
                            }
                            double originalBalance = balance;
                            remainingBalance = balance - item.getPrice();
                            //double newBalance = balance - item.getPrice();
                            balance = remainingBalance;
                            itemInventory = item.getInventory();
                            int newInventory = itemInventory - 1;
                            item.setInventory(newInventory);


                            //System.out.println(item.getName() + " " + item.getPrice() + " " + remainingBalance + " " + item.getDisplayMessage());
                            System.out.printf("$%.2f $%.2f",item.getPrice(), remainingBalance);
                            System.out.println(item.getDisplayMessage());


                            String purchaseItemMessage = item.getName() + " " + item.getRow() + " "+ "$" + originalBalance + " "+ "$"+ remainingBalance;
                            vendingLog.logTransaction(purchaseItemMessage);
                        } else {
                            System.out.println("Item is sold out");
                        }
                    }
                }

            } catch (Exception e) {
                System.exit(0);
            }
        }
        //purchase exception, try catch

        return userRowSelection;
    }

    public List<Edible> getItems() {
        return inventory.getVmItems();
    }

    //inventory--
    //take the object, and getInventory
    //if !inventory > 0, then print "SOLD OUT"
    //compare price to balance

    //if price > balance, then print "Please add more funds"
    //feedMoney()
    //DISPENSE - display message [item.getMessage]
    //update balance
    //log purchase
}


//giveChange

//Log



