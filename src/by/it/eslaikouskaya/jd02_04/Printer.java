package by.it.eslaikouskaya.jd02_04;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Printer {
    public void print(Var result) {
        if (result != null)
            System.out.println(result);
    }

    void println(Map<String, Var> vars) {
        Set<Map.Entry<String, Var>> entries = vars.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}
