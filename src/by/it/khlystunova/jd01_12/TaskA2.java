package by.it.khlystunova.jd01_12;

import java.util.*;
/*TaskA2.В main класса TaskA2 определите два множества (a и b) на основе целых чисел.
Создайте статические методы для определения пересечения множеств getCross и
объединения множеств getUnion.
Покажите работу этих методов на примере двух разных множеств
(например, HashSet aи TreeSet b).*/
public class TaskA2 {
    public static void main(String[] args) {
        Integer[] arrayA ={1,2,3,4,4,4,5,6,6,3,3};
        Integer[] arrayB = {4,4,5,5,6,6,7,7,8,8,9,10,4,4,6,6};
        List<Integer> listA = Arrays.asList(arrayA);
        List<Integer> listB = Arrays.asList(arrayB);
        HashSet<Integer> a = new HashSet<>(listA);
        TreeSet<Integer> b = new TreeSet<>(listB);
        System.out.println("HashSet: "+a);
        System.out.println("TreeSet: "+b);
        System.out.println("Cross: "+ getCross(a,b));
        System.out.println("Union: "+ getUnion(a,b));
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);//добавляет в результат элементы из коллекции б которые есть там и там.
        return result;
    }

    private  static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
      Set<Integer> result = new HashSet<>(a);
      result.addAll(b);
      return result;
    }
}
