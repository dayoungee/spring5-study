package org.example.chap07.main;

import org.example.chap07.ExeTimeCalculator;
import org.example.chap07.ImpeCalculator;
import org.example.chap07.RecCalculator;

public class MainProxy {
    public static void main(String[] args) {
        ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
        System.out.println(ttCal1.factorial(20));

        ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
        System.out.println(ttCal2.factorial(20));

    }
}
