package com.techelevator;

import com.techelevator.view.Edible;
import com.techelevator.view.Menu;
import com.techelevator.view.Operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI extends Operations {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				getItems();


			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				feedMoney();
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
