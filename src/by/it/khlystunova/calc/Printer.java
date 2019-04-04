package by.it.khlystunova.calc;

import java.util.Iterator;
import java.util.Map;

public class Printer {
    public void print(Var result) {
        if (result!=null)
        System.out.println(result);
    }

    public static void printVar(Map vars){
        Iterator it = vars.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove();
        }
    }
}

