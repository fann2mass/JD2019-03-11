package by.it.zalesky.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws ArithmeticException{

        Scanner scanner = new Scanner(System.in);
        double d = -20;

        try {
            if (d<0)
                throw new ArithmeticException("d>0");
           }

        catch (ArithmeticException e) {
            System.out.println("Переменная меньше нуля");


        }
    }

}
