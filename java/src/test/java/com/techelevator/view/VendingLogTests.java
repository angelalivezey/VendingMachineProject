package com.techelevator.view;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class VendingLogTests {

    //*********************************EXCEPTIONS*************************************\\

    @Test(expected = FileNotFoundException.class)
    public void throw_FNF_exception_properly() throws FileNotFoundException {
        File gobbityglosk = new File("globbity.txt");
        try (Scanner testObj = new Scanner(gobbityglosk)) {

        } catch (FileNotFoundException e) {
            throw e;
        }

        //if exception ISN't thrown, the test fails
    }

    @Test(expected = IOException.class)
    public void throw_IOE_exception_properly() throws IOException {
        File gobbityglosk = new File("globbity.txt");
        try (Scanner testObj = new Scanner(gobbityglosk)) {

        } catch (IOException e) {
            throw e;
        }

    }
}
