package com.techelevator;

import com.techelevator.view.*;

import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

    //***************************************PROPERTIES***********************************************************\\

    private VendingMachine awesomeVendingMachine = new VendingMachine();
    private boolean isShopping;
    private Menu menu;
    private VendingLog vendingLog = new VendingLog();

    //***************************************FIRST MENU***********************************************************\\
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

    //***************************************SECOND MENU***********************************************************\\
    private static final String SECOND_MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String SECOND_MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String SECOND_MAIN_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] SECOND_MAIN_MENU_OPTIONS = {SECOND_MAIN_MENU_OPTION_FEED_MONEY, SECOND_MAIN_MENU_OPTION_SELECT_PRODUCT, SECOND_MAIN_MENU_OPTION_FINISH_TRANSACTION};

    //***************************************FEED MONEY MENU********************************************************\\
    private static final String FEED_MENU_OPTION_1 = "One Dollar";
    private static final String FEED_MENU_OPTION_2 = "Two Dollars";
    private static final String FEED_MENU_OPTION_5 = "Five Dollars";
    private static final String FEED_MENU_OPTION_10 = "Ten Dollars";
    private static final String[] FEED_MONEY_MENU = {FEED_MENU_OPTION_1, FEED_MENU_OPTION_2, FEED_MENU_OPTION_5, FEED_MENU_OPTION_10};


    //***************************************CLI BEGINS HERE*********************************************************\\


    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                List<Edible> items = awesomeVendingMachine.getItems();
                for (Edible item : items) {
                    String inventory = String.valueOf(item.getInventory());
                    if(item.getInventory() == 0){
                        inventory = "SOLD OUT";
                    }
                    String price = String.format("$%.2f", item.getPrice());
                    System.out.println(item.getRow() + " " + item.getName() + " " + price + " Inventory Remaining: " + inventory);
                    System.out.println();
                }

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                isShopping = true;

                while (isShopping) {
                    String transaction = (String) menu.getChoiceFromOptions(SECOND_MAIN_MENU_OPTIONS);
                    if (transaction.equals(SECOND_MAIN_MENU_OPTION_FEED_MONEY)) {

                        String moneyChoice = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU);
                        if (moneyChoice.equals(FEED_MENU_OPTION_1)) {
                            awesomeVendingMachine.feedMoney(1.0);
                            System.out.printf("Current Balance is: $%.2f", awesomeVendingMachine.getBalance());
                        } else if (moneyChoice.equals(FEED_MENU_OPTION_2)) {
                            awesomeVendingMachine.feedMoney(2.0);
                            System.out.printf("Current Balance is: $%.2f", awesomeVendingMachine.getBalance());
                        } else if (moneyChoice.equals(FEED_MENU_OPTION_5)) {
                            awesomeVendingMachine.feedMoney(5.0);
                            System.out.printf("Current Balance is: $%.2f", awesomeVendingMachine.getBalance());
                        } else if (moneyChoice.equals(FEED_MENU_OPTION_10)) {
                            awesomeVendingMachine.feedMoney(10.0);
                            System.out.printf("Current Balance is: $%.2f", awesomeVendingMachine.getBalance());
                        } else {
                            System.out.println("Enter the dollar amount with dollar sign");
                        }

                    } else if (transaction.equals(SECOND_MAIN_MENU_OPTION_SELECT_PRODUCT)) {

                        List<Edible> items = awesomeVendingMachine.getItems();
                        String userRow;
                        for (Edible item : items) {
                            userRow = item.getRow();
                            String inventory = String.valueOf(item.getInventory());
                            if(item.getInventory() == 0){
                                inventory = "SOLD OUT";
                            }
                            String price = String.format("$%.2f", item.getPrice());
                            System.out.println(item.getRow() + " " + item.getName() + " " + price + " Inventory Remaining: " + inventory);
                            System.out.println();
                        }
                        System.out.println("Select an item(ex. A2):");
                        Scanner userInput = new Scanner(System.in);
                        String userRowSelection = userInput.nextLine();

                        try {
                            awesomeVendingMachine.purchaseItem(userRowSelection);
                        } catch (ItemSoldOutException e) {
                            String exceptionMessage = "SOLD OUT EXCEPTION: " + userRowSelection;
                            vendingLog.logTransaction(exceptionMessage);
                            System.out.println("Sorry, item sold out");
                        } catch (InsufficientFundsException e) {
                            String exceptionMessage = String.format("INSUFFICIENT FUNDS EXCEPTION: $%.2f", awesomeVendingMachine.getBalance());
                            vendingLog.logTransaction(exceptionMessage);
                            System.out.println("Insufficient balance. Please add money");
                        } catch (InvalidSelectionException e) {
                            String exceptionMessage = "INVALID SELECTION EXCEPTION: " + userRowSelection;
                            vendingLog.logTransaction(exceptionMessage);
                            System.out.println("Sorry, invalid selection. Please try again.");
                        }

                    } else if (transaction.equals(SECOND_MAIN_MENU_OPTION_FINISH_TRANSACTION)) {
                        ChangeMaker changeOutput = awesomeVendingMachine.makeChange();
                        System.out.println("Your change is: " + changeOutput.getQuarters() + " " + "quarters, "
                                + changeOutput.getDimes() + " " + "dimes, " + changeOutput.getNickels() + " " + "nickels");
                        isShopping = false;
                    }
                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.out.println("Thank you for your purchase!");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();


    }
}
