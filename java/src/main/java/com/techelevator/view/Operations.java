package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Operations {
    double balance = 0.0;
    Inventory inventory = new Inventory();


    public void feedMoney() {
        System.out.println("Please input money in valid, whole dollar amounts:  ");
        Scanner giveMeMoney = new Scanner(System.in);
        String moneyGiven = giveMeMoney.nextLine();
        //add money, increase balance, until the choose to exit out.
        if (moneyGiven.equals("1") || moneyGiven.equals("2") || moneyGiven.equals("5") || moneyGiven.equals("10")) {
            balance += Double.parseDouble(moneyGiven);
            System.out.println("Current Balance Is: " + balance);
        } else {
            System.out.println("Please input valid whole dollar amount.");
        }
        //LOG

    }

    //purchase method:
    public void purchaseItems(){

        inventory.getItems();
        System.out.println("Select a product:");
        Scanner userInput = new Scanner(System.in);
        String userSelection = userInput.nextLine();
        //if userSelection matches row;
        Edible row = inventory.vmItems.get(0);

        if(!userSelection.equals(row)){
            System.out.println("Please input a valid entry. For item in row B2 enter B2.");
        }

        for(Edible item : inventory.vmItems){

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


}
