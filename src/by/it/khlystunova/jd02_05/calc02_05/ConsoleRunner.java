package by.it.khlystunova.jd02_05.calc02_05;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static ResourceManager manager = ResourceManager.INSTANCE;

    public static void main(String[] args) {
        try{
            Var.load();
            Var.loadLogs();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("You can select language:\nen-English\nbe-беларуский\nru-русский");
        Scanner scanner1 = new Scanner(System.in);
        String text = scanner1.nextLine();
        Locale locale;
        switch (text){
            case "ru":
                locale = new Locale("ru", "RU");
                manager.setLocale(locale);
                break;
            case "en":
                locale = new Locale("en", "EN");
                manager.setLocale(locale);
                break;
            case "be":
                locale = new Locale("be", "BY");
                manager.setLocale(locale);
                break;
            default:
                    System.out.println("Неправильный ввод");
        }
        System.out.println(manager.getString(Msg.WELCOME));
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
