package Assignment1;

import java.util.Scanner;

class Details {
    private String name;
    private double price;
    private int quantity;
    private String type;
    private double tax;
    private double total;

    Scanner scanner = new Scanner(System.in);
    private static int type_flag = 0;

    //list of constants
    private static final String RAW = "raw";
    private static final String MANUFACTURED = "manufactured";
    private static final String IMPORTED = "imported";
    private static final String EMPTY_FIELD = "Value not entered!";
    private static final String MISSING_NAME_FIELD = "name should be the first field in the specified format '-name name_of_product'!";
    private static final String WRONG_TYPE_FIELD = "'type' field is incorrect !";
    private static final String EMPTY_FIELD_NAME = "name field is mandatory!";
    private static final String EMPTY_FIELD_TYPE = "type field is mandatory!";

    Details() {
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
        this.type = "";
        this.tax = 0.0;
        this.total = 0.0;
    }


    String getName() {
        return this.name;
    }

    double getPrice() {
        return this.price;
    }

    String getType() {
        return this.type;
    }

    double getTax() {
        return this.tax;
    }

    double getTotal() {
        return this.total;
    }

    int getItemDetails(String[] args) {

        int index = 1;
        int result = 1;
        try {
            if ("-name".compareTo(args[0]) == 0) {
                while (args[index].charAt(0) != '-') {
                    this.name = this.name + " " + args[index];
                    index = index + 1;
                }
                getOtherDetails(args, index);
            } else {
                System.out.println(MISSING_NAME_FIELD);
                result = 0;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(MISSING_NAME_FIELD);
            result = 0;

        } finally {

            return result;
        }

    }

    void getOtherDetails(String[] args, int index) {
        try {
            int type_flag = 0;

            while (index < args.length) {

                switch (args[index]) {

                    case "-quantity":
                        this.quantity = Integer.parseInt(args[index + 1]);
                        index = index + 2;
                        break;

                    case "-price":
                        this.price = Double.parseDouble(args[index + 1]);
                        index = index + 2;
                        break;

                    case "-type":
                        String type = processType(args[index + 1]);
                        this.type = type;
                        index = index + 2;
                        break;

                }
            }
            if (type_flag == 0) {
                System.out.println(EMPTY_FIELD_TYPE);
                inputTypeField();
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(EMPTY_FIELD);
        }
    }

    String processType(String type) {
        try {
            int value = Integer.parseInt(type);
            if (value == 1) {
                type_flag = 1;
                return RAW;
            } else if (value == 2) {
                type_flag = 1;
                return MANUFACTURED;
            } else if (value == 3) {
                type_flag = 1;
                return IMPORTED;
            } else {
                System.out.println(WRONG_TYPE_FIELD);
                inputTypeField();
            }
        } catch (NumberFormatException e) {
            System.out.println(WRONG_TYPE_FIELD);
            inputTypeField();
        }
        return WRONG_TYPE_FIELD;
    }

    void inputTypeField() {
        System.out.println("Do you want to continue? (y/n)");
        char choice = scanner.nextLine().charAt(0);
        if (choice == 'n') {
            System.exit(0);
        } else if (choice == 'y') {
            System.out.println("Enter -type");
            String item_type = scanner.next();
            item_type += scanner.nextLine();
            String[] type_arr = item_type.split(" ");
            this.type = processType(type_arr[1]);
        }


    }

    public void calculateTaxAndTotal() {
        if (this.price != 0) {

            if (RAW.equals(this.type)) {
                this.tax = TaxCalculation.taxForRaw(this.price);

            } else if (MANUFACTURED.equals(this.type)) {
                this.tax = TaxCalculation.taxForManufactured(this.price);

            } else if (IMPORTED.equals(this.type)) {
                this.tax = TaxCalculation.taxForImported(this.price);
            }
            this.total = this.tax + this.price;
        }

    }

}
