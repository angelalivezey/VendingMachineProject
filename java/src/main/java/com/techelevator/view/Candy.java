package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends Edible{

    public Candy(String row, String name, double price, String displayMessage,String itemType){
        super(row,name,price,displayMessage, itemType);

    }


    @Override
    public String getDisplayMessage(){
        return "Munch Munch, Yum!";
    }



}
