package com.techelevator.view;

public class Chip extends Edible{
    public Chip(String row, String name, double price){
        super(row,name,price);
    }




    @Override
    public String getDisplayMessage(){
        return "Crunch Crunch! Yum!";
    }

}
