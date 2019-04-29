package by.it.eslaikouskaya.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        try {
            Var.load();
        } catch (Exception e) {
            System.out.println("Невозможно загрузить данные");
        }
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine().replace(" ", "");
            if (expression.equals("end")) break;
            Var result = null;
            try{
                result = parser.calc(expression);
            }
            catch (CalcException e){
                System.out.println(e.getMessage());
            }
            printer.print(result);
            if (expression.equals("printvar")){
                printer.println(Var.getVars());
            }
        }
    }
}
