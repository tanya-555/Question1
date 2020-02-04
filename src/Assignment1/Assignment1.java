package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment1 {

    //list of constants
    private static final String MISSING_TYPE = "Missing type field!";
    private static final String MISSING_NAME = "name not entered!";

    public static void main(String[] args) {

        ArrayList<Details> items = new ArrayList<Details>();
        Scanner scanner = new Scanner(System.in);
        char choice = 'n';
        System.out.println("Item details consists of the following parameters :\n -name, -type, -price, -quantity \n Valid values for type are : \n 1. Raw \n 2. Manufactured \n 3. Imported \n name and type are mandatory fields \n name should be the first parameter");
        do {
            String inputArray[];
            String input;
            Details detail = new Details();
            System.out.println("Enter details for new item:");

            input = scanner.next();
            input += scanner.nextLine();
            inputArray = input.split(" ");
            int result = detail.getItemDetails(inputArray);
            if (result == 1) {
                items.add(detail);
                detail.calculateTaxAndTotal();
            }
            System.out.println("Do you want to enter details of other items (y/n):");
            choice = scanner.next().charAt(0);

        } while (choice == 'y');
        printDetails(items);
    }

    private static void printDetails(ArrayList<Details> items) {
        for (int i = 0; i < items.size(); i++) {
            Details detail = items.get(i);
            if (detail.getType() == "") {
                System.out.println(MISSING_TYPE);
                continue;
            }
            if (detail.getName() == "") {
                System.out.println(MISSING_NAME);
            } else {
                System.out.println("Item name : " + detail.getName());
            }
            String result = String.format("Item price: %f \nTax per item: %f \nTotal price: %f", detail.getPrice(), detail.getTax(), (detail.getTotal()));
            System.out.println(result);
            System.out.println("--------------------------------------------------------------");
        }
    }
}