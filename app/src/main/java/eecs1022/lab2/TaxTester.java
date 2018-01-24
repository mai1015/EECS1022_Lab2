package eecs1022.lab2;

/**
 * Model tester
 * Created by mai1015 on 2018-01-23.
 */

public class TaxTester {
    public static void main(String[] args) {
        System.out.println(PayerStatus.valueOf("Household") == PayerStatus.Household);

        TaxPayer payer1 = new TaxPayer("Dennis", 0, "Single");
        TaxPayer payer2= new TaxPayer("Dalao", 1000, "Household");
        TaxPayer payer3 = new TaxPayer("Alen", 186476, "Single");
        TaxPayer payer4 = new TaxPayer("Mark", 137035, "Married");
        TaxPayer payer5 = new TaxPayer("Winner", 100000000, "Single");
        TaxPayer payer6 = new TaxPayer("Mark", 11800, "Household");

        System.out.print(payer1);
        System.out.print(payer2);
        System.out.print(payer3);
        System.out.print(payer4);
        System.out.print(payer5);
        System.out.print(payer6);
    }
}
