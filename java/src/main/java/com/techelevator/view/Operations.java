package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Operations {
    double balance = 0.0;
    List<Edible> vmItems = new ArrayList<Edible>();

    public void getItems() {
        //make return class
        //move to inventory class
        File vendingMachineFile = new File("vendingmachine.csv");
        try (Scanner readVMFile = new Scanner(vendingMachineFile)) {
            while (readVMFile.hasNextLine()) {
                String line = readVMFile.nextLine();
                String[] splitStr = line.split("\\|");
                Edible vmItem = new Edible();
                for (int i = 0; i < splitStr.length; i++) {
                    //A1|Potato Crisps|3.05|Chip
                    vmItem.setRow(splitStr[0]);

                    vmItem.setName(splitStr[1]);

                    vmItem.setPrice(Double.parseDouble(splitStr[2]));

                    vmItem.setItemType(splitStr[3]);

                    System.out.println(vmItem.getRow() + " " + vmItem.getName() + " " + vmItem.getPrice());

                    vmItems.add(vmItem);
                    break;

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(-1);
        }
        //thoughts: maybe make this void because we don't need to return anything, we just need to be able to do it..?
    }

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
        //
        int inventory; //unsure if need this or not
        getItems();
        System.out.println("Select a product:");
        Scanner userInput = new Scanner(System.in);
        String userSelection = userInput.nextLine();
        //if userSelection matches row;
        Edible row = vmItems.get(0);

        if(!userSelection.equals(row)){
            System.out.println("Please input a valid entry. For item in row B2 enter B2.");
        }

        for(Edible item : vmItems){

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
