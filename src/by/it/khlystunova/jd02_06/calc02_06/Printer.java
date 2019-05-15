package by.it.khlystunova.jd02_06.calc02_06;


import java.util.Iterator;
import java.util.Map;

public class Printer {

    public void print(Var result) {
        if (result!=null)
        System.out.println(result);
    }

    static void printVar(Map vars){
        Iterator it = vars.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove();
        }
    }
}

