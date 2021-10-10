package com.techelevator.view;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class VendingLog {
    private String message = "";

    public VendingLog(){
        this.message = message;
        logTransaction(message);
    }

    /**
     *
     * @param message coming from different methods that call this log method
     * creates a file to write to
     * appends the file with each transaction
     * uses local date type dd/mm/yyyy and hh:mm:ss a (10/10/2021 11:36 AM)
     */
    public void logTransaction(String message) {

        try (PrintWriter logger = new PrintWriter(new FileWriter("logs/vendinglog.txt", true))) {
            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");

            String formatDateTime = now.format(formatter);

            logger.println(formatDateTime + " " + message);

        } catch (FileNotFoundException e) {
            VendingLogException logException = new VendingLogException(e.getMessage());
            throw logException;
        } catch (IOException e) {
            throw new VendingLogException((e.getMessage())); //line 34 can be written as line 38
        }
    }


}
