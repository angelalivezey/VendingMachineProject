package com.techelevator.view;

public class Gum extends Edible {
    public Gum(String row, String name, double price, String displayMessage,String itemType){
        super(row,name,price,displayMessage, itemType);
    }




    @Override
    public String getDisplayMessage(){
        return "Chew Chew! Yum!";
    }

}
