package com.techelevator.view;

public class ChangeMaker {
    private final static int PENNIES_PER_QUARTER = 25;
    private final static int PENNIES_PER_DIME = 10;
    private final static int PENNIES_PER_NICKEL = 5;
    private int quarters;
    private int dimes;
    private int nickels;


    /**
     *
     * @param remainingBalance from purchaseItem method is then converted to pennies and further divided into each change type
     * the change type in pennies is a static final variable in the change maker class.
     */
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


}
