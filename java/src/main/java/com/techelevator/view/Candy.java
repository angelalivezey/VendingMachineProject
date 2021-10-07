package com.techelevator.view;

public class Candy extends Edible{

    public Candy(String row, String name, double price){
        super(row,name,price);

    }


    @Override
    public String getDisplayMessage(){
        return "Munch Munch, Yum!";
    }



}
