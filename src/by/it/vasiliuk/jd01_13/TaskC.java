package by.it.vasiliuk.jd01_13;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TaskC {

    private static List<Double> list = new ArrayList<>();
    private static int countException;
    static {
        countException = 0;
    }

    private static String text;


    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            text = scanner.nextLine();
            readData();
        }
    }

    private static void readData() throws Exception {
        try {
            double num = Double.parseDouble(text);
            list.add(num);
        } catch (NumberFormatException e) {
            if(countException==5) {
                throw new Exception("Слишком много ошибок...");
            }
            countException++;
            Thread.sleep(100);
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }


    }
}