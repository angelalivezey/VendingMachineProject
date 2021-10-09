package com.techelevator.view;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VendingLog {
    private String message = "";

    public VendingLog(){
        this.message = message;
        logTransaction(message);
    }


    public void logTransaction(String message) {
        //creates a file to write out to
        try(PrintWriter logger = new PrintWriter(new FileWriter("logs/vendinglog.txt", true))){
            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");

            String formatDateTime = now.format(formatter);

            logger.println(formatDateTime+ " " + message);

        }catch(FileNotFoundException e){
            VendingLogException logException = new VendingLogException(e.getMessage());
            throw logException;
        }catch(IOException e){

            throw new VendingLogException((e.getMessage())); //line 34 can be written as line 38
        }














//        try (Scanner vendingLogScanner = new Scanner(vendingLog);
//             PrintWriter transactionWriter = new PrintWriter("vendinglog.txt");
//             PrintWriter appendedTransactionWriter = new PrintWriter("appendedvendinglog.txt")) {
//
//            List<String> lines = new ArrayList<String>();
//            while (vendingLogScanner.hasNextLine()) {
//                String line = vendingLogScanner.nextLine();
//                lines.add(line);
//            }
//
//            Collections.sort(lines);
//
//            // Write the lines to sortedWriter
//            for (String line : lines) {
//                transactionWriter.println(line);
//            }
//
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found. Boo hoo.");
//        }


    }


    //Printwriter
    //creates a file to write out to
    //will write each event (money deposit, purchase, sale, change made)
    //appended
    //add this to:
    // FeedMoney Method
    //purchase method
    //give change method


}
