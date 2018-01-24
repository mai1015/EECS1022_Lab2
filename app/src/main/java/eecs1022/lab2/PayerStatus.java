package eecs1022.lab2;

/**
 * Keep the status of a payer.
 * Created by mai1015 on 2018-01-23.
 */

public enum PayerStatus {
    Single   ("Single", 8350, 33950, 82250),
    Married  ("Married", 16700, 67900, 137050),
    Household("Household", 11950, 45500, 17450);

    private final String text;
    private final double tax1;
    private final double tax2;
    private final double tax3;
    //private final double tax4;

    PayerStatus(String t, double lv1, double lv2, double lv3) {
        this.text = t;
        tax1 = lv1;
        tax2 = lv2;
        tax3 = lv3;
        //tax4 = lv4;
    }

    public double getRate(int level) {
        switch (level) {
            case 0:
                return 0.1;
            case 1:
                return 0.15;
            case 2:
                return 0.25;
            default:
                return 0.3;
        }
    }

    public int getLevel(double income) {
        if (tax1 >= income) {
            return 0;
        } else if (tax2 >= income) {
            return 1;
        } else if (tax3 >= income) {
            return 2;
        }
        return 3;
    }

    public double getTaxCap(int level) {
        switch (level) {
            case 3:
                return 0;
            case 2:
                return tax3;
            case 1:
                return tax2;
            default:
                return tax1;
        }
    }

    public double getTaxFloor(int level) {
        switch (level) {
            case 3:
                return tax3;
            case 2:
                return tax2;
            case 1:
                return tax1;
            default:
                return 0;
        }
    }

    public String toString() {
        return text;
    }
}
