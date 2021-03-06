package by.it.vasiliuk.jd01_09;


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
            Map.Entry coup = (Map.Entry) it.next();
            System.out.println(coup.getKey() + " = " + coup.getValue());
            it.remove();
        }
    }
}

