package org.example.chap07;

public class RecCalculator implements Calculator{
    @Override
    public long factorial(long num) {
        long start = System.currentTimeMillis();

        if(num == 0) return 1;
        else return num * factorial(num - 1);
    }
}
