package by.it.vasiliuk.jd01_11;

import java.util.*;

public class ListB<E> extends ListA<E>{

    @Override
    public void add(int index, E element) {
        E[] left_arr = Arrays.copyOf(elements, index + 1 );
        left_arr[left_arr.length-1] = element;
        E[] right_arr = Arrays.copyOf(elements, elements.length-index);
        int j = 0;
        for (int i = index; i < elements.length; i++) {
            right_arr[j] = elements[i];
            j++;
        }
        System.out.println("Right Array");
        for (E e : right_arr) {
            System.out.println(e);;
        }
        System.out.println("Right Array");
        elements = Arrays.copyOf(elements, elements.length+1);
        System.arraycopy(left_arr, 0, elements, 0, left_arr.length);
        System.out.println("Left Array");
        for (E e : left_arr) {
            System.out.println(e);;
        }
        System.out.println("Left Array");

        elements = Arrays.copyOf(left_arr, right_arr.length+left_arr.length);
        int length = elements.length;
        System.out.println(length);
        int k =0;
        for (int i = left_arr.length; i < elements.length; i++) {
            elements[i] = right_arr[k];
            k++;
        }
        size++;

    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        List<E> sm = (List<E>)c;
        elements = Arrays.copyOf(elements, size + sm.size());
        for (E e : sm) {
            elements[size++] = e;
        }
        return true;
    }

    @Override
    public E set(int index, E element) {
        E elemInIndex = elements[index];
        elements[index] = element;
        return elemInIndex;
    }
}
