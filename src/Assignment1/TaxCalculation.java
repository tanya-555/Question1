package Assignment1;

public class TaxCalculation {

    static double taxForRaw(double price) {
        return 0.125 * price;
    }

    static double taxForManufactured(double price) {
        return 0.125 * price + (0.02 * (price + 0.125 * price));
    }

    static double taxForImported(double price) {

        double tax = price * 0.1;
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
