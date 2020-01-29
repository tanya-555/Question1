package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment1 {

    //list of constants
    private static final String MISSING_TYPE = "Missing type field!";
    private static final String MISSING_NAME = "name not entered!";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Details> items = new ArrayList<Details>();
        Scanner sc = new Scanner(System.in);
        char choice = 'n';
        do {
            String inpArray[];
            String input;
            Details detail = new Details();
            int field_count=0;
            System.out.println("Enter new item details:");

            System.out.println("Enter name in the format -name followed by name");
            input = sc.next();
            input += sc.nextLine();
            inpArray = input.split(" ");
            field_count = field_count+1;
            detail.getItemDetails(inpArray, field_count);

            System.out.println("Enter price, quantity and type in any order in the format -price/quantity/order followed by price/quantity/order");
            input = sc.next();
            input += sc.nextLine();
            inpArray = input.split(" ");
            field_count = field_count+1;
            detail.getItemDetails(inpArray, field_count);

            items.add(detail);
            detail.calculateTax();

            System.out.println("Do you want to enter details of other items (y/n):");
            choice = sc.next().charAt(0);

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
            System.out.println("Item price : " + detail.getPrice());
            System.out.println("Tax per item : " + detail.getTax());
            System.out.println("Total price is : " + (detail.getPrice() + detail.getTax()));
            System.out.println("--------------------------------------------------------------");
        }
    }
}