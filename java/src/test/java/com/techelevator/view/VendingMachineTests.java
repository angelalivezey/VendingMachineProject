package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class VendingMachineTests {


    //*********************************FEED MONEY TESTS*****************************\\
    @Test
    public void correct_balance_of_5_returned() {
        double expected = 5.0;

        VendingMachine vmTest = new VendingMachine();
        vmTest.feedMoney(5.0);
        double actual = vmTest.getBalance();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void correct_balance_of_7_returned() {
        double expected = 7.0;

        VendingMachine vmTest = new VendingMachine();
        vmTest.feedMoney(2.0);
        vmTest.feedMoney(5.0);
        double actual = vmTest.getBalance();

        Assert.assertEquals(expected, actual, 0);
    }


    //*********************************PURCHASE ITEM TESTS*****************************\\
    @Test
    public void correct_remaining_balance_after_1_purchase() {
        VendingMachine vmTest = new VendingMachine();

        double expected = 4.25;

        vmTest.feedMoney(5.0);
        vmTest.purchaseItem("D4");

        double actual = vmTest.getRemainingBalance();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void correct_remaining_balance_after_3_purchase() {
        VendingMachine vmTest = new VendingMachine();

        double expected = 5.75;

        vmTest.feedMoney(10.0);
        vmTest.purchaseItem("B3");
        vmTest.purchaseItem("C1");
        vmTest.purchaseItem("C3");

        double actual = vmTest.getRemainingBalance();

        Assert.assertEquals(expected, actual, 0);
    }
    @Test
    public void correct_remaining_balance_after_3_purchase_of_same_item() {
        VendingMachine vmTest = new VendingMachine();

        double expected = 6.25;

        vmTest.feedMoney(10.0);
        vmTest.purchaseItem("C1");
        vmTest.purchaseItem("C1");
        vmTest.purchaseItem("C1");

        double actual = vmTest.getRemainingBalance();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void correct_remaining_balance_after_5_purchase() {
        VendingMachine vmTest = new VendingMachine();

        double expected = 2.50;

        vmTest.feedMoney(10.0);
        vmTest.purchaseItem("B3");
        vmTest.purchaseItem("C1");
        vmTest.purchaseItem("C3");
        vmTest.purchaseItem("B4");
        vmTest.purchaseItem("C2");

        double actual = vmTest.getRemainingBalance();

        Assert.assertEquals(expected, actual, 0);
    }



    //*********************************EXCEPTIONS*************************************\\

    @Test(expected = InvalidSelectionException.class)
    public void throw_invalid_exception() {
        VendingMachine vmTest = new VendingMachine();
        vmTest.purchaseItem("mickey mouse");
    }

    @Test(expected = InsufficientFundsException.class)
    public void throw_insufficient_funds_exception() {
        VendingMachine vmTest = new VendingMachine();
        vmTest.purchaseItem("D4");
    }

    @Test(expected = ItemSoldOutException.class)
    public void throw_sold_out_exception() {
        VendingMachine vmTest = new VendingMachine();
        vmTest.feedMoney(5.0);
        vmTest.purchaseItem("D4");
        vmTest.purchaseItem("D4");
        vmTest.purchaseItem("D4");
        vmTest.purchaseItem("D4");
        vmTest.purchaseItem("D4");
        vmTest.purchaseItem("D4");
    }


}
