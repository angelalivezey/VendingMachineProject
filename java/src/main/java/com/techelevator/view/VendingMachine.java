package com.techelevator.view;


import java.util.List;

public class VendingMachine {
    double balance;
    double remainingBalance = balance;
    Inventory inventory = new Inventory();
    List<Edible> items = inventory.getVmItems();
    VendingLog vendingLog = new VendingLog();

    /**
     * @param moneyGiven by user selection from menu
     * @return balance
     * logs the transaction of money given and the balance afterwards
     */
    public double feedMoney(double moneyGiven) {
        balance += moneyGiven;
        String feedMoneyMessage = String.format("FEED MONEY: $%.2f $%.2f", moneyGiven, balance);
        vendingLog.logTransaction(feedMoneyMessage);
        return balance;
    }

    /**
     * @param userRowSelection from user input as a string
     * @return isValidSelection whether or not the row exists in vendingmachine.csv
     */
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

    /**
     * @return ChangeMaker object from ChangeMaker class
     * logs transaction, includes remaining balance returned to user and balance is set to 0.
     */

    public ChangeMaker makeChange() {
        ChangeMaker makeChange = new ChangeMaker(remainingBalance);
        balance = balance - remainingBalance;

        String changeMakerMessage = String.format("GIVE CHANGE: $%.2f $%.2f", remainingBalance, balance);


        vendingLog.logTransaction(changeMakerMessage);
        return makeChange;
    }


    /**
     * @param userRowSelection
     * @return
     * @throws InvalidSelectionException  when userRowSelection is invalid.
     * @throws InsufficientFundsException when balance is less than price of item user wants
     * @throws ItemSoldOutException       when item inventory is 0.
     */
    public String purchaseItem(String userRowSelection) {

        int itemInventory = 0;
        if (!isValidSelection(userRowSelection)) {
            RuntimeException e = new InvalidSelectionException();
            throw e;
        } else {

            for (Edible item : items) {
                if (userRowSelection.equals(item.getRow())) {
                    if (item.getInventory() > 0) {

                        if (item.getPrice() > balance) {

                            InsufficientFundsException e = new InsufficientFundsException();
                            throw e;

                        }
                        double originalBalance = balance;
                        remainingBalance = balance - item.getPrice();

                        balance = remainingBalance;
                        itemInventory = item.getInventory();
                        int newInventory = itemInventory - 1;
                        item.setInventory(newInventory);

                        System.out.printf("$%.2f $%.2f", item.getPrice(), remainingBalance);
                        System.out.println(" " + item.getDisplayMessage());


                        String formatNumbers = String.format("$%.2f $%.2f", originalBalance, remainingBalance);
                        String purchaseItemMessage = item.getName() + " " + item.getRow() + " " + formatNumbers;
                        vendingLog.logTransaction(purchaseItemMessage);
                    } else {
                        throw new ItemSoldOutException();
                    }
                }
            }

        }

        return userRowSelection;
    }

    public List<Edible> getItems() {
        return inventory.getVmItems();
    }
}




