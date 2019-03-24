package by.it.Runtso.jd01_02;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        step1();

        int mounth=scanner.nextInt();
        step2(mounth);

        double a=scanner.nextDouble();
        double b=scanner.nextDouble();
        double c=scanner.nextDouble();

        step3(a, b, c);
    }

    private static void step3(double a, double b, double c) {
        double disc=b*b-4*a*c;
        double x1, x2;

        if(disc<0) System.out.println("корней нет");
        else if(disc==0) {
            x1=-b/(2*a);
            System.out.println(x1); }
        else  {
            x1=-b+Math.sqrt(disc)/(2*a);
            x2=-b-Math.sqrt(disc)/(2*a);
            System.out.println(x1+" "+x2); }

    }

    private static void step2(int mounth) {
        switch (mounth) {
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");
            }
        }


        }

        private static void step1 () {
            for (int i = 0; i <= 25; i++) {
                System.out.print(i + " ");
                if (i % 5 == 0) System.out.println();

            }


        }
    }
