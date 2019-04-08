package by.it.khlystunova.jd01_13;

import java.util.HashMap;


public class TaskA {
    public static void main(String[] args) {
        try{
            if (Math.random()>0.5)
                new HashMap<String, String>(null);
            else Integer.parseInt("привет");
        }catch (NumberFormatException | NullPointerException e){
            String name = e.getClass().getName();
            System.out.printf("name: %s\n",name);
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                String className = element.getClassName();
                if(className.equals(TaskA.class.getName())) {
                    System.out.printf("class: %s\n", className);
                    int lineNumber = element.getLineNumber();
                    System.out.printf("line: %s", lineNumber);
                }
            }
            e.getStackTrace();
        }

    }
}
