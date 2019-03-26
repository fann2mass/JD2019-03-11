package by.it.khlystunova.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        step1();
        int i = scanner.nextInt();
        step2(i);
        step3(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
    }

    private static void step3(double a,double b,double c) {//2 4 2
        double discriminant = (b*b) - (4*a*c);
        if(discriminant<0){
            System.out.println("корней нет");
        }
        else if(discriminant==0){
            double root = (b*(-1))/ (2 * a);
            System.out.println(root);
        }else if(discriminant>0){
            double rootOne = (b*(-1) + Math.sqrt(discriminant)) / (2 * a);
            double rootTwo = (b*(-1) - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(rootOne+" "+rootTwo);
        }

    }

    private static void step2(int mounth) {
switch (mounth){
    case 1:{
        System.out.println("январь");
        break;
    }
    case 2:{
        System.out.println("февраль");
        break;
    }
    case 3:{
        System.out.println("март");
        break;
    }
    case 4:{
        System.out.println("апрель");
        break;
    }
    case 5:{
        System.out.println("май");
        break;
    }
    case 6:{
        System.out.println("июнь");
        break;
    }
    case 7:{
        System.out.println("июль");
        break;
    } case 8:{
        System.out.println("август");
        break;
    }
    case 9:{
        System.out.println("сентябрь");
        break;
    }
    case 10:{
        System.out.println("октябрь");
        break;
    }
    case 11:{
        System.out.println("ноябрь");
        break;
    }
    case 12:{
        System.out.println("декабрь");
        break;
    }
    default:{
        System.out.println("нет такого месяца");
    }

}
    }

    private static void step1() {
        int count = 1;
        for (int i = 1; i <= 25; i++) {
                System.out.print(i + " ");
                count++;
                if(count>5){
                    System.out.println();
                    count = 1;
                }
            }
            }



    }



