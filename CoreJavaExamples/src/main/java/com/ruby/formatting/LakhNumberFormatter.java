package com.ruby.formatting;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;

/***
 *
 * This class formats the  indian standard number format i.e. lack and carore
 * 100000 -> 1,00,000
 * 1000000 -> 10,00,000
 * 10000000.23 -> 1,00,00,000.23
 */
public class LakhNumberFormatter {
    public static void main(String[] args) {
        LakhNumberFormatter formatter = new LakhNumberFormatter();

        double[] inputAmounts = new double[]{100000, 1000000, 10000000.24, 1000.23, 10000.89, 1999.95};
        for (double amount : inputAmounts) {
            formatter.formatAmount(amount);
            formatter.usingCustomFormatter(amount);
        }

     }

    /**
     * Format using IBM library
     *
     * @param amount
     * @return
     */
    private String formatAmount(double amount) {
        /*
        //The original java  code that  does not work , though I would expect it to
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String moneyString = formatter.format(amount);

        */
        Format format = com.ibm.icu.text.NumberFormat.getNumberInstance(new Locale("en", "IN"));
        String moneyString = format.format(amount);
        System.out.format("Formatted the input %s to indian form %s %n", amount, moneyString);
        return moneyString;
    }

    /**
     * Format by doing mathematical division and then formatting
     *
     * @param amount
     * @return
     */
    private String usingCustomFormatter(double amount) {
        String moneyString;
        if (amount < 1000) {
            moneyString = format("###.##", amount);
            System.out.format("Formatted the input %s to indian form %s Using custom formatter %n", amount, moneyString);
            return moneyString;
        } else {
            double hundredsWithDecimal = amount % 1000;
            int thousandAndAbove = (int) (amount / 1000);
            //When building the return string if I use StringBuilder IntelliJ is suggesting me to use String ..Why?
            //Should this be replaced with StringBuilder - What will be advantages and disadvantages of doing that
            moneyString = format(",##", thousandAndAbove) + ',' + format("000.00", hundredsWithDecimal);
            System.out.format("Formatted the input %s to indian form %s Using custom formatter %n", amount, moneyString);
            return moneyString;
        }
    }


    private static String format(String pattern, Object value) {
        return new DecimalFormat(pattern).format(value);
    }

    public String usingCustomFormatter(String amount) {
        //find index of . , if it is not negative  then
        // if index is <2 then just return string
        // if index is ==3 then format for one ,
        // if index is >3 then  this index -3  and substring that part
        //format first part to have comma after 2 chars and append the substringed str

        return null;
    }

    //To Check
/*    public String getIndianCurrencyFormat(String amount) {
        StringBuilder stringBuilder = new StringBuilder();
        char amountArray[] = amount.toCharArray();
        int a = 0, b = 0;
        for (int i = amountArray.length - 1; i >= 0; i--) {
            if (a < 3) {
                stringBuilder.append(amountArray[i]);
                a++;
            } else if (b < 2) {
                if (b == 0) {
                    stringBuilder.append(",");
                    stringBuilder.append(amountArray[i]);
                    b++;
                } else {
                    stringBuilder.append(amountArray[i]);
                    b = 0;
                }
            }
        }
        return stringBuilder.reverse().toString();
    }*/
}

