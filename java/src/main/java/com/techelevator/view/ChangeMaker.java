package com.techelevator.view;

public class ChangeMaker {
    private final static int PENNIES_PER_QUARTER = 25;
    private final static int PENNIES_PER_DIME = 10;
    private final static int PENNIES_PER_NICKEL = 5;
    private int quarters;
    private int dimes;
    private int nickels;



//take double convert to an int,
//convert to pennies

    public ChangeMaker(double remainingBalance) {
        int remainingBalanceInPennies = (int) (remainingBalance * 100);

        this.quarters = remainingBalanceInPennies / PENNIES_PER_QUARTER;
        remainingBalanceInPennies = remainingBalanceInPennies % PENNIES_PER_QUARTER;

        this.dimes = remainingBalanceInPennies / PENNIES_PER_DIME;
        remainingBalanceInPennies = remainingBalanceInPennies % PENNIES_PER_DIME;

        this.nickels = remainingBalanceInPennies / PENNIES_PER_NICKEL;
        remainingBalanceInPennies = remainingBalanceInPennies % PENNIES_PER_NICKEL;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    //"Your balance was: " newBalance
//"Your change is: " q + d + n

    //gives change
    //gets balance
    //subtracts purchase amount
    //updates balance
    //update feed money method to have remaining balance
    //take remaining balance and divide it into quarters,dimes,nickels
    //assign to remaining balance and print

    //Instance of a change maker
    //print line in the user interface
    //change maker result
    //CLI getters


}
