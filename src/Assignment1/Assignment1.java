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
            System.out.println("Enter new item details:");
            String input = sc.next();
            input += sc.nextLine();
            String inpArray[] = input.split(" ");
            Details detail = new Details();
            detail.getItemDetails(inpArray);
            items.add(detail);
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