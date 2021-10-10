package com.techelevator.view;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InventoryTests {

    //*********************************EXCEPTIONS*************************************\\

    @Test(expected = FileNotFoundException.class)
    public void file_not_found_exception_thrown_properly() throws FileNotFoundException {
       File fileTest = new File("randomfile.txt");
        try (Scanner testObj = new Scanner(fileTest)){

        }catch(FileNotFoundException e){
            throw e;
        }
    }
}
