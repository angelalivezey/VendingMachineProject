package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Operations {

    public Operations() {

    }

    public void getItems() {
        List<Edible> vmItems = new ArrayList<Edible>();
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
                    //get this to where each line prints only once...
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(-1);
        }
        //thoughts: maybe make this void because we don't need to return anything, we just need to be able to do it..?
    }

    public void feedMoney() {
        double balance = 0.0;
        System.out.println("Please input money in valid, whole dollar amounts:  ");
        Scanner giveMeMoney = new Scanner(System.in);
        String moneyGiven = giveMeMoney.nextLine();
        if (moneyGiven.equals("1") || moneyGiven.equals("5") || moneyGiven.equals("10") || moneyGiven.equals("20")) {
            balance += Double.parseDouble(moneyGiven);
            System.out.println("Current Balance Is: " + balance);
        } else {
            System.out.println("Please input valid whole dollar amount.");
        }

    }

    //purchase method:


    //giveChange

    //Log


}
