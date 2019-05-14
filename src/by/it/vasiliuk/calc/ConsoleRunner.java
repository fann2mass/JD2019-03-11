package by.it.vasiliuk.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        try{
            Var.load();
            Var.loadLogs();
        }catch (Exception e){
            e.printStackTrace();
        }
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String expression = scanner.nextLine().replace(" ","");
            if(expression.equals("end"))break;
            if(expression.equals("printVar"))
                Printer.printVar(Var.getVar());
            if(expression.equals("sortVar"))
                Var.sortVar();
            try {
                Var result = parser.calc(expression);
                printer.print(result);
                if(result!=null)
                    Var.saveLogs(result.toString());

            } catch (CalcException e) {
                Var.saveLogs(e.getMessage());
                System.out.println(e.getMessage());
            }
        }

    }
}