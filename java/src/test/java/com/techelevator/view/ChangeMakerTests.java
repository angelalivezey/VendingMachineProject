package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class ChangeMakerTests {

    //*********************************MAKE CHANGE TESTS*****************************\\
    @Test
    public void make_correct_change_with_quarters_and_dimes(){
        String expected = "Your change is: " + 28 + " " + "quarters, "
                + 1 + " " + "dimes, " + 0 + " " + "nickels";

        ChangeMaker changeMaker = new ChangeMaker(7.10);
        String actual = "Your change is: " + changeMaker.getQuarters() + " " + "quarters, "
                + changeMaker.getDimes() + " " + "dimes, " + changeMaker.getNickels() + " " + "nickels";

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void make_correct_change_with_quarters_and_nickels(){
        String expected = "Your change is: " + 28 + " " + "quarters, "
                + 0 + " " + "dimes, " + 1 + " " + "nickels";

        ChangeMaker changeMaker = new ChangeMaker(7.05);
        String actual = "Your change is: " + changeMaker.getQuarters() + " " + "quarters, "
                + changeMaker.getDimes() + " " + "dimes, " + changeMaker.getNickels() + " " + "nickels";

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void make_correct_change_with_quarters_and_dimes_nickels(){
        String expected = "Your change is: " + 28 + " " + "quarters, "
                + 1 + " " + "dimes, " + 1 + " " + "nickels";

        ChangeMaker changeMaker = new ChangeMaker(7.15);
        String actual = "Your change is: " + changeMaker.getQuarters() + " " + "quarters, "
                + changeMaker.getDimes() + " " + "dimes, " + changeMaker.getNickels() + " " + "nickels";

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void make_correct_change_with_no_quarters(){
        String expected = "Your change is: " + 0 + " " + "quarters, "
                + 1 + " " + "dimes, " + 1 + " " + "nickels";

        ChangeMaker changeMaker = new ChangeMaker(.15);
        String actual = "Your change is: " + changeMaker.getQuarters() + " " + "quarters, "
                + changeMaker.getDimes() + " " + "dimes, " + changeMaker.getNickels() + " " + "nickels";

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void make_correct_change_with_no_quarters_or_dimes(){
        String expected = "Your change is: " + 0 + " " + "quarters, "
                + 0 + " " + "dimes, " + 1 + " " + "nickels";

        ChangeMaker changeMaker = new ChangeMaker(.05);
        String actual = "Your change is: " + changeMaker.getQuarters() + " " + "quarters, "
                + changeMaker.getDimes() + " " + "dimes, " + changeMaker.getNickels() + " " + "nickels";

        Assert.assertEquals(expected,actual);
    }

}
