package com.techelevator.view;

public class Edible {
    private String row;
    private String name;
    private double price;
    private String itemType;
    private String displayMessage;
    private int inventory;


    private static final int MAX_AMOUNT = 5;


    public Edible (){

    }

    public Edible(String row, String name, double price){
        this.name = name;
        this.price = price;
        this.displayMessage = displayMessage;
        this.row = row;
        this.itemType = itemType;
        this.inventory = MAX_AMOUNT;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getInventory(){
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }
}
