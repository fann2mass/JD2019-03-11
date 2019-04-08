package by.it.khlystunova.jd01_12;

import java.util.*;
/*TaskC2.Попробуйте решить заново задачу TaskA2 для любого количества множеств
 на входе метода, а также для различных типов чисел в каждом из множеств (generics).
В main покажите работоспособность решения.*/

@SuppressWarnings("all")
public class TaskC2 {

    public static void main(String[] args){

        processWithDoubleSets(); //проверка работоспособности методов на множествах типа Double
        processWithIntegerSets();
    }

    private static void processWithIntegerSets() {
        Integer[] integer1 ={1,2,3,4,4};
        Integer[] integer2 ={1,2,3,6,3,3};
        Integer[] integer3 ={1,2,3,4,4,4,5,3};
        List<Integer> listInt1 = Arrays.asList(integer1);
        List<Integer> listInt2 = Arrays.asList(integer2);
        List<Integer> listInt3 = Arrays.asList(integer3);
        Set<Integer> i1 = new HashSet<>(listInt1);
        Set<Integer> i2 = new HashSet<>(listInt2);
        Set<Integer> i3 = new HashSet<>(listInt3);
        System.out.println("-------Проверка на множествах типа Integer-----");
        System.out.println("Integer1: "+i1);
        System.out.println("Integer2:"+i2);
        System.out.println("Integer3: "+i3);
        System.out.println("Cross: "+ getCross(i1,i2,i3));
        System.out.println("Union: "+ getUnion(i1,i2,i3));
    }


    private static void processWithDoubleSets() {
        Double[] double1 ={1d,2d,3d,4d,4d};
        Double[] double2 ={1d,2d,3d,6d,3d,3d};
        Double[] double3 ={1d,2d,3d,4d,4d,4d,5d,3d};
        List<Double> listD1 = Arrays.asList(double1);
        List<Double> listD2 = Arrays.asList(double2);
        List<Double> listD3 = Arrays.asList(double3);
        Set<Double> d1 = new HashSet<>(listD1);
        Set<Double> d2 = new HashSet<>(listD2);
        Set<Double> d3 = new HashSet<>(listD3);
        System.out.println("-------Проверка на множествах типа Double-----");
        System.out.println("Double1: "+d1);
        System.out.println("Double2:"+d2);
        System.out.println("Double3: "+d3);
        System.out.println("Cross: "+ getCross(d1,d2,d3));
        System.out.println("Union: "+ getUnion(d1,d2,d3));
    }

    private static <E> Set<E> getCross(Set<?> ...sets) {
        Set<E> result = new HashSet<>();
        Set<E> union = (Set<E>) getUnion(sets);
        Iterator<E> iterator = union.iterator();
        boolean flag = true;
        while(iterator.hasNext()){
            E next = iterator.next();
            for (Set<?> set : sets) {
                 if(!set.contains(next))flag = false;
            }
            if(flag){
                result.add(next);
            }
        }
        return result;
    }


    private  static <E> Set<E> getUnion(Set<? extends E> ...sets ){
        Set<E> result = new TreeSet<>();
        for (Set<?> set : sets) {
           result.addAll((Set<? extends E>) set);
        }
        return result;
    }
}
