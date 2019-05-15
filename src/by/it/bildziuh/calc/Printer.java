package by.it.bildziuh.calc;

import java.util.Map;

class Printer {
    void print(Var var){
        if (var!=null)
            System.out.println(var);
    }

    void print(Map<String, Var> vars){
        for (Map.Entry<String, Var> entry : vars.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());
    }



}
