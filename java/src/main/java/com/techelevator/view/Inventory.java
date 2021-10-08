package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private List<Edible> vmItems = new ArrayList<Edible>();

    public Inventory(){
        loadItems();
    }

    public List<Edible> getVmItems() {
        return vmItems;
    }

    private void loadItems() {
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
                    if(splitStr[3].equalsIgnoreCase("chip")){
                        Chip chippity = new Chip(splitStr[0],splitStr[1],Double.parseDouble(splitStr[2]));
                        vmItems.add(chippity);
                    } else if(splitStr[3].equalsIgnoreCase("candy")){
                        Candy candyItem = new Candy(splitStr[0],splitStr[1],Double.parseDouble(splitStr[2]));
                        vmItems.add(candyItem);
                    } else if(splitStr[3].equalsIgnoreCase("drink")){
                        Drink drinkItem = new Drink(splitStr[0],splitStr[1],Double.parseDouble(splitStr[2]));
                        vmItems.add(drinkItem);
                    } else {
                        Gum gumItem = new Gum(splitStr[0], splitStr[1], Double.parseDouble(splitStr[2]));
                        vmItems.add(gumItem);
                    }
//                    System.out.println(vmItem.getRow() + " " + vmItem.getName() + " " + vmItem.getPrice());

                    break;

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(-1);
        }

    }




}
