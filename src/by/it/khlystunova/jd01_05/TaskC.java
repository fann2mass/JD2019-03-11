package by.it.khlystunova.jd01_05;

import static java.lang.Math.*;
/*
По данной функции(result) сформировать одномерный массив,
состоящий из 20-40 элементов, при изменеии аргумента
в заданном интервале(5.33<=x<=9).Организовать форматный вывод массива,
с заголовком и индексами. Сформировать новый массив из элементов больших 3.5
и найти их среднее геометрическое.
 */
public class TaskC {
    public static void main(String[] args) {
        step1();
    }
    private static void step1() {
        double[] array = new double[20];
        double result;
        int i = -1;
            for (double x = 5.33; x <= 9 ;x += 0.1835) {
                result = pow((x*x)+4.5,1/3d);
                array[i+=1] = result;
            }
        for (int i1 = 0; i1 < array.length; i1++) {
            System.out.printf("%-1s[%-2d] = %-3e","v",i1,array[i1]);
            System.out.println();
        }
        double [] arrayNew = new double[15];
        int k=0;
        double sum =0;
        for (double v : array) {
            if (v > 3.5) {
                arrayNew[k] = v;
                sum = arrayNew[k] + sum;
                k++;
            }
        }
        double GeometricMean = sum/arrayNew.length;
        System.out.println("Новый массив из элементов больше 3.5");
        for (int i1 = 0; i1 < arrayNew.length; i1++) {
            System.out.printf("%-1s[%-2d] = %-3e","v",i1,arrayNew[i1]);
            System.out.println();
        }
        System.out.println("Среднее геометрическое значение"+GeometricMean);
    }
}
