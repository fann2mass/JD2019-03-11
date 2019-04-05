package by.it.akhmelev.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] arrayA = {1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 3, 3, 4, 4, 1};
        List<Integer> listA = Arrays.asList(arrayA);
        List<Integer> listB = Arrays.asList(4, 5, 6, 6, 7, 8, 9, 9, 10, 4, 4, 6, 6);
        HashSet<Integer> a = new HashSet<>(listA);
        TreeSet<Integer> b = new TreeSet<>(listB);
        System.out.println("HashSet:" + a);
        System.out.println("TreeSet:" + b);
        System.out.println("Cross: " + getCross(a, b));
        System.out.println("Union: " + getUnion(a, b));
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
}
