package by.it.narushevich.calc;

import java.util.Iterator;
import java.util.Map;

class Printer {
    public void print(Var result) {
        if (result != null)
            System.out.println(result);
    }

    void printMap(Map vars) {
        Iterator it = vars.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove();
        }
    }
}
