package com.techelevator.view;

public class Gum extends Edible {
    public Gum(String row, String name, double price){
        super(row,name,price);
    }




    @Override
    public String getDisplayMessage(){
        return "Chew Chew! Yum!";
    }

}
