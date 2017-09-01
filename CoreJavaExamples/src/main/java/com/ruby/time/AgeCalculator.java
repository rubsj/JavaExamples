package com.ruby.time;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by rjha on 3/10/2017.
 */
public class AgeCalculator {


    public static void main(String[] args) {
        LocalDate retireage = LocalDate.of(2015, Month.NOVEMBER, 25);
        //LocalDate birthyear = LocalDate.of(1957 , 11 , 6);

        LocalDate birthyear = retireage.minusYears(58);
        System.out.println("papa birth " +birthyear.getYear());

        LocalDate lokesh = LocalDate.of(2017, Month.FEBRUARY, 6);
        //LocalDate birthyear = LocalDate.of(1957 , 11 , 6);
        System.out.println(lokesh);

        LocalDate lokeshbirth = lokesh.minusYears(34);
        System.out.println("lokesh birth year " + lokeshbirth.getYear());
    }
}
