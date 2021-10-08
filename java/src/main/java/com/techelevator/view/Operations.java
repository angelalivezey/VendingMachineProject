package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operations {
    double balance = 0.0;
    Inventory inventory = new Inventory();


    public double feedMoney(double moneyGiven) {
        balance += moneyGiven;
        System.out.println("Current Balance is: " + "$" + balance);
        return balance;

    }

    //purchase method: row
    public void purchaseItem(String row) {
        inventory.getVmItems();
        if ()
        //if userSelection matches row;
        //purchase exception, try catch
        //is it in stock
        //do they have enough $ to buy it

        //get items that returns inventory's get items

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



