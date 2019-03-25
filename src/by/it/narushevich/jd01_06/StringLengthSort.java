package by.it.narushevich.jd01_06;

import java.util.Comparator;

class StringLengthSort implements Comparator<String> {
    public int compare(String o1, String o2) {
        if(o1.length() > o2.length()) return 1;
        else if(o1.length() < o2.length()) return -1;
            else return 0;
        }
}

