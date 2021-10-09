package com.techelevator.view;

import java.sql.SQLOutput;
import java.util.List;

public class VendingMachine {
    double balance;
    double remainingBalance = balance;
    Inventory inventory = new Inventory();
    List<Edible> items = inventory.getVmItems();
    VendingLog vendingLog = new VendingLog();


    public double feedMoney(double moneyGiven) {
        balance += moneyGiven;
        //System.out.println("Current Balance is: " + "$" + balance);

        String feedMoneyMessage = String.format("FEED MONEY: $%.2f $%.2f", moneyGiven, balance);
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

        String changeMakerMessage = String.format("GIVE CHANGE: $%.2f $%.2f", remainingBalance, balance);

        //String giveChangeMessage = "GIVE CHANGE: " +" "+ "$"+ remainingBalance +" "+ "$"+ balance;
        vendingLog.logTransaction(changeMakerMessage);

        return makeChange;
    }


    /**
     * @param userRowSelection
     * @return
     * @throws InvalidSelectionException when userRowSelection is invalid.
     * @throws InsufficientFundsException when balance is less than price of item user wants
     * @throws ItemSoldOutException when item inventory is 0.
     */
    public String purchaseItem(String userRowSelection) {

        int itemInventory = 0;
        if (!isValidSelection(userRowSelection)) {
            RuntimeException e = new InvalidSelectionException();
            throw e;
            //throw new InvalidSelectionException();
        } else {

            for (Edible item : items) {
                if (userRowSelection.equals(item.getRow())) {
                    if (item.getInventory() > 0) {
                        //try catch here:
                        if (item.getPrice() > balance) {
                            //replace with exception
                            InsufficientFundsException e = new InsufficientFundsException();
                            throw e;
                            //throw new InsufficientBalanceException();
                        }
                        double originalBalance = balance;
                        remainingBalance = balance - item.getPrice();
                        //double newBalance = balance - item.getPrice();
                        balance = remainingBalance;
                        itemInventory = item.getInventory();
                        int newInventory = itemInventory - 1;
                        item.setInventory(newInventory);

                        //System.out.println(item.getName() + " " + item.getPrice() + " " + remainingBalance + " " + item.getDisplayMessage());
                        System.out.printf("$%.2f $%.2f", item.getPrice(), remainingBalance);
                        System.out.println(" " + item.getDisplayMessage());


                        String formatNumbers = String.format("$%.2f $%.2f", originalBalance, remainingBalance);
                        String purchaseItemMessage = item.getName() + " " + item.getRow() + " " + formatNumbers;
                        vendingLog.logTransaction(purchaseItemMessage);
                    } else {
                        //throw new ItemSoldOutException();
                        System.out.println("Sorry, item is sold out.");
                    }
                }
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



