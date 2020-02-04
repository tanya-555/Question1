package Assignment1;

public class TaxCalculation {

    //list of constants
    private static final double RAW_TAX_PERCENT = 0.125;
    private static final double MANUFACTURED_TAX_PERCENT = 0.02;
    private static final double IMPORTED_TAX_PERCENT = 0.1;

    static double taxForRaw(double price) {
        return RAW_TAX_PERCENT * price;
    }

    static double taxForManufactured(double price) {
        return RAW_TAX_PERCENT * price + (MANUFACTURED_TAX_PERCENT * (price + RAW_TAX_PERCENT * price));
    }

    static double taxForImported(double price) {

        double tax = price * IMPORTED_TAX_PERCENT;
        double surcharge = 0.0;
        double total = price + tax;

        //calculating surcharge amount

        if (total <= 100) {
            surcharge = 5;
        } else if (total <= 200) {
            surcharge = 10;
        } else {
            surcharge = 0.05 * total;
        }
        tax = tax + surcharge;
        return tax;
    }
}
