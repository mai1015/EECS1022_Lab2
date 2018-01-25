package eecs1022.lab2;

/**
 * Represents a payer in the country.
 * This model calculates the tax.
 * Created by mai1015 on 2018-01-23.
 */

public class TaxPayer {

    private String name;
    private double income;
    private PayerStatus status;

    public TaxPayer(String n, double ic, String s) {
        name = n;
        income = ic;
        status = PayerStatus.valueOf(s);
    }

    public double calculateTax() {
        int level = status.getLevel(income);
        double result = 0.0;
        result += calculatePart(status.getTaxFloor(level), status.getTaxCap(level), status.getRate(level));
        for (int i = (level-1); i >= 0; i--) {
            result += status.getFixedTax(i);
        }
        return result;
    }

    public double calculatePart(double floor, double cap, double rate) {
        if (income >= floor && (income < cap || cap == 0.0) ) {
            return (income - floor) * rate;
        } else if (income >= cap) {
            return (cap - floor) * rate;
        }
        return 0;
    }

    private static String convertNum(int i) {
        switch (i) {
            case 0:
                return "I";
            case 1:
                return "II";
            case 2:
                return "III";
            case 3:
                return "IV";
        }
        return "";
    }

    @Override
    public String toString() {
        String ret = String.format("%s, your tax due is %.2f \n" +
                        "Calculation is based on the scheme of %s Filing:\n",
                name, calculateTax(), status.toString());
        int level = status.getLevel(income);
        for (int i = 0; i <= level; i++) {
            ret = String.format("%sPart %s: %.2f\n", ret, convertNum(i),
                    level != i ? status.getFixedTax(i) :
                            calculatePart(status.getTaxFloor(i), status.getTaxCap(i), status.getRate(i)));
        }
        return ret;
    }
}