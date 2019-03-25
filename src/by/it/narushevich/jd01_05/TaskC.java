package by.it.narushevich.jd01_05;

import java.util.Scanner;
import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");

        int n = 0;

        while (n <= 20 || n>=40) {
            if(scanner.hasNextInt()){
                n = scanner.nextInt();
                if(n <= 20 || n>=40){
                    System.out.println("Введенное число должно быть больше 20 и меньше 40. Повторите ввод:");
                }
            } else {
                System.out.println("Вы ввели не число. Повторите ввод:");
                scanner.next();
            }
        }

        double[] randomArray = new double[n];
        int count = 0;                              //счетчик элементов больших 3,5 пока равен 0
        for (int i = 0; i < randomArray.length; i++) {
            double x = random()*4+5.33;             //генерация случайного х в диапазоне [5,33; 9]
            randomArray[i] = cbrt(pow(x, 2.0)+4.5); // вычисление значения элемента на основе сгенерированного х
            if (randomArray[i]>3.5)                 //если сгенерирован элемент больше 3,5
                count++;                            //счетчик увеличивается на 1
        }

        System.out.println("Массив M[]:");
        printArray(randomArray, "M"); // вывод массива в 4 колонки с заголовком и индексом
        System.out.println();

        double[] newRandomArray = new double[count]; // объявление нового массива, длина которого
                                                    // равна количеству элементов больших 3,5
        int index = 0;
        for (double element : randomArray)          // перебираем исходный массив и записываем в новый
            if (element > 3.5) {                    //только те элементы, которые больше 3,5
                newRandomArray[index] = element;
                index++;
            }

        System.out.println("Массив N[] из элементов массива M[] больше 3,5:");
        printArray(newRandomArray, "N");        // вывод массива в 4 столбца с индексами и заголовками
        System.out.println();

        double middleGeom = middleGeom(newRandomArray); //вызов метода, вычисляющего среднее геометрическое
                                                        // элементов массива
        System.out.println("Среднее геометрическое элементов массива N = "+middleGeom);

    }

    /**
     * @param arr массив чисел в формате double
     * @param name заголовок элемента массива, стоящий перед индексом
     */

    private static void printArray(double[] arr, String name){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%2d]=%-6.4f  ", name, i, arr[i]);
            if ((i+1)%4==0 || i+1==arr.length)
                System.out.println();
        }
    }

    /**
     * @param array массив элементов, для которых нужно посчитать среднее геометрическое
     * @return среднее геометрическое массива, полученного на вход
     */
    private static double middleGeom(double[] array) {
        int counter = 0;            // счетчик элементов в массиве
        double production = 1;      // произведение элементов массива инициировано 1

        for (double element : array)    //перебор массива
            if (element != 0) {         // если элемент не равен нулю,
                production *= element;  //произведение увеличивается в элемент раз
                counter++;              // счетчик увеличивается на 1
            }

        return pow(production, 1.0 / (double) counter); //формула среднего геометрического
                                                        //корень n-ой степени из произведения членов массива,
                                                        //где n, число элементов массива
    }
}
