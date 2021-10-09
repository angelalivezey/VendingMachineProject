package com.techelevator;

import com.techelevator.view.*;

import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {
    VendingLog vendingLog = new VendingLog();

    //Instance
    private VendingMachine awesomeVendingMachine = new VendingMachine();
    private boolean isShopping;
    private Inventory newInt = new Inventory();

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

    //Second Menu
    private static final String SECOND_MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String SECOND_MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String SECOND_MAIN_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] SECOND_MAIN_MENU_OPTIONS = {SECOND_MAIN_MENU_OPTION_FEED_MONEY, SECOND_MAIN_MENU_OPTION_SELECT_PRODUCT, SECOND_MAIN_MENU_OPTION_FINISH_TRANSACTION};

    //feed money options
    private static final String FEED_MENU_OPTION_1 = "One Dollar";
    private static final String FEED_MENU_OPTION_2 = "Two Dollars";
    private static final String FEED_MENU_OPTION_5 = "Five Dollars";
    private static final String FEED_MENU_OPTION_10 = "Ten Dollars";
    private static final String[] FEED_MONEY_MENU = {FEED_MENU_OPTION_1, FEED_MENU_OPTION_2, FEED_MENU_OPTION_5, FEED_MENU_OPTION_10};

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() { //is it a valid double, positive double
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                List<Edible> items = awesomeVendingMachine.getItems();
                for (Edible item : items) {

                    String price = String.format("$%.2f", item.getPrice());
                    System.out.println(item.getRow() + " " + item.getName() + " " + price + " Inventory Remaining: " + item.getInventory());
                    System.out.println();
                }

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                isShopping = true;

                while (isShopping) {
                    String transaction = (String) menu.getChoiceFromOptions(SECOND_MAIN_MENU_OPTIONS);
                    if (transaction.equals(SECOND_MAIN_MENU_OPTION_FEED_MONEY)) {
                        //System.out.println("Please input money in valid, whole dollar amounts: ()  ");
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
                        //purchase items stuff!
                        List<Edible> items = awesomeVendingMachine.getItems();
                        String userRow;
                        for (Edible item : items) {
                            userRow = item.getRow();

                            String price = String.format("$%.2f", item.getPrice());
                            System.out.println(item.getRow() + " " + item.getName() + " " + price + " Inventory Remaining: " + item.getInventory());
                            System.out.println();
                        }
                        System.out.println("Select an item(ex. A2):");
                        Scanner userInput = new Scanner(System.in);
                        String userRowSelection = userInput.nextLine();
                        //validate user input then do the rest on business side (purchasing etc)

                        //try multiple catches
                        try {
                            awesomeVendingMachine.purchaseItem(userRowSelection);
                        } catch (ItemSoldOutException e) {
                            System.out.println("Sorry, item sold out");
                        } catch (InsufficientFundsException e) {
                            System.out.println("Insufficient balance. Please add money");
                        } catch (InvalidSelectionException e) {
                            System.out.println("Sorry, invalid selection. Please try again.");
                        }

                    } else if (transaction.equals(SECOND_MAIN_MENU_OPTION_FINISH_TRANSACTION)) {
                        ChangeMaker changeOutput = awesomeVendingMachine.makeChange();
                        System.out.println("Your change is: " + changeOutput.getQuarters() + " " + "quarters, " + changeOutput.getDimes() + " " + "dimes, " + changeOutput.getNickels() + " " + "nickels");
                        //give change and log the purchase
                        isShopping = false;
                    }
                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                //This is where we put the sales report! *When you are panicking, Don't forget!
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();


    }

//Operations methods:
//	public void getItems() {
//		List<Edible> vmItems = new ArrayList<Edible>();
//		File vendingMachineFile = new File("vendingmachine.csv");
//		try(Scanner readVMFile = new Scanner(vendingMachineFile)){
//			while(readVMFile.hasNextLine()){
//				String line = readVMFile.nextLine();
//				String[] splitStr = line.split("\\|");
//				Edible vmItem = new Edible();
//				for(int i = 0; i < splitStr.length; i++){
//					//A1|Potato Crisps|3.05|Chip
//					vmItem.setRow(splitStr[0]);
//					vmItem.setName(splitStr[1]);
//					vmItem.setPrice(Double.parseDouble(splitStr[2]));
//					vmItem.setItemType(splitStr[3]);
//					System.out.println(vmItem.getRow() + " " + vmItem.getName() + " " + vmItem.getPrice());
//					vmItems.add(vmItem);
//				}
//			}
//		}catch(FileNotFoundException e){
//			System.out.println("File not found");
//			System.exit(-1);
//		}
//		//thoughts: maybe make this void because we don't need to return anything, we just need to be able to do it..?
//	}


    //feedMoney


    //Log


}
