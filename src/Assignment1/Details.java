package Assignment1;

class Details {
    private String name;
    private double price;
    private int quantity;
    private String type;
    private double tax;

    //constants
    private static final String INVALID_INPUT = "Invalid Input!";
    private static final String EMPTY_FIELD = "Value not entered!";
    private static final String MISSING_NAME_FIELD = "name should be the first field in the specified format '-name name_of_product'!";
    private static final String IMPROPER_TYPE_FIELD = "'type' field is absent or incorrect!";
    private static final String EMPTY_FIELD_NAME = "name field is mandatory!";

    Details() {
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
        this.type = "";
        this.tax = 0.0;
    }

    //for testing
    void setType(String type) {
        this.type = type;
    }

    void setPrice(double price) {
        this.price = price;
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

    void getItemDetails(String[] args, int field_count) {

        try {
            if (field_count == 1) {

                if ("-name".compareTo(args[0]) != 0) {
                    System.out.println(MISSING_NAME_FIELD);
                    System.exit(0);
                } else {
                    this.name = args[1];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(EMPTY_FIELD_NAME);
            System.exit(0);
        }
        if (field_count == 2) {
            for (int i = 0; i < args.length; i++) {
                try {
                    if ("-type".compareTo(args[i]) == 0 && "-price".compareTo(args[i + 1]) != 0 && "-quantity".compareTo(args[i + 1]) != 0) {
                        this.type = args[i + 1];
                        i = i + 1;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(EMPTY_FIELD);
                    System.exit(0);
                }
                try {
                    if ("-price".compareTo(args[i]) == 0 && "-type".compareTo(args[i + 1]) != 0 && "quantity".compareTo(args[i + 1]) != 0) {
                        try {
                            this.price = Double.parseDouble(args[i + 1]);
                            i = i + 1;
                        } catch (NumberFormatException e) {
                            System.out.println(INVALID_INPUT);
                            System.exit(0);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(INVALID_INPUT);
                    System.exit(0);
                }
                try {
                    if ("-quantity".compareTo(args[i]) == 0 && "-type".compareTo(args[i + 1]) != 0 && "-price".compareTo(args[i + 1]) != 0) {
                        try {
                            this.quantity = Integer.parseInt(args[i + 1]);
                            i = i + 1;
                        } catch (NumberFormatException e) {
                            System.out.println(INVALID_INPUT);
                            System.exit(0);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(EMPTY_FIELD);
                    System.exit(0);
                }
            }
        }
    }

    public void calculateTax() {
        if (this.price != 0) {

            TaxCalculation tax_calc = new TaxCalculation();

            if ("raw".equals(this.type)) {
                this.tax = tax_calc.taxForRaw(this.price);

            } else if ("manufactured".equals(this.type)) {
                this.tax = tax_calc.taxForManufactured(this.price);

            } else if ("imported".equals(this.type)) {
                this.tax = tax_calc.taxForImported(this.price);
            } else {
                System.out.println(IMPROPER_TYPE_FIELD);
            }
        }
    }

}
