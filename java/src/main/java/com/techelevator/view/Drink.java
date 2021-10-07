package com.techelevator.view;

public class Drink extends Edible{

    public Drink(String row, String name, double price){
        super(row,name,price);
    }




    @Override
    public String getDisplayMessage(){
        return "Glug Glug! Yum!";
    }

}
