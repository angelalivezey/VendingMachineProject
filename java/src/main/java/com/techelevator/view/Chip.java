package com.techelevator.view;

public class Chip extends Edible{
    public Chip(String row, String name, double price, String displayMessage,String itemType){
        super(row,name,price,displayMessage, itemType);
    }




    @Override
    public String getDisplayMessage(){
        return "Crunch Crunch! Yum!";
    }

}
