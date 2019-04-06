package by.it.bolotko.jd01_12;

import java.util.HashMap;
import java.util.Map;


    public class Test
    {
        public static void main(String[] args) {
            String str = "If the type of an expression is a reference type,"
                    + " then the class of the referenced object, or even whether"
                    + " the value is a reference to an object rather than null,"
                    + " is not necessarily known at compile time. There are a"
                    + " few places in the Java programming language where the "
                    + "actual class of a referenced object affects program "
                    + "execution in a manner that cannot be deduced from the "
                    + "type of the expression.";
            str = str.toLowerCase();
            str = str.replaceAll("\\W", " ");

            Map<String, Integer> map = new HashMap<>();
            for(String s: str.split(" ")) {
                if(map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                }
                else {
                    map.put(s, 1);
                }
            }
            map.remove("");
            System.out.println(map);
        }
    }

