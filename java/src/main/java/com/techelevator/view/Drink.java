package com.techelevator.view;

public class Drink extends Edible{

    public Drink(String row, String name, double price, String displayMessage,String itemType){
        super(row,name,price,displayMessage, itemType);
    }




    @Override
    public String getDisplayMessage(){
        return "Glug Glug! Yum!";
    }

}
