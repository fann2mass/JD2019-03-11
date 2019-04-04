package by.it.khlystunova.jd01_11;

/*TaskB. Свой ListB. Напишите класс ListB<T>, который реализует toString()и
 6 методов add(T e),remove(int index), get(int index), set(int index,T e),
 add(int index, T e), addAll(List<?> c) интерфейса List<T>(реализация остальных –фиктивная).*/

import java.util.*;

public class ListB<E> extends ListA<E>{

    @Override
    public void add(int index, E element) {
        E[] leftArray = Arrays.copyOf(elements, index + 1 );
        leftArray[leftArray.length-1] = element;//one[0] three[1] index[2]
        E[] rightArray = Arrays.copyOf(elements, elements.length-index);
        int j = 0;
        for (int i = index; i < elements.length; i++) {
            rightArray[j] = elements[i];
            j++;
        }
        System.out.println("----rightArray-----");
        for (E e : rightArray) {
            System.out.println(e);;
        }
        System.out.println("----rightArray-----");
        elements = Arrays.copyOf(elements, elements.length+1);//длина нашего массива + массива из элементов коллекции
        for (int i = 0; i < leftArray.length; i++) {
            elements[i] = leftArray[i];
        }
        System.out.println("----leftArray-----");
        for (E e : leftArray) {
            System.out.println(e);;
        }
        System.out.println("----leftArray-----");

        elements = Arrays.copyOf(leftArray, rightArray.length+leftArray.length);//длина нашего массива + массива из элементов коллекции
        int length = elements.length;
        System.out.println(length);
        int k =0;
        for (int i = leftArray.length; i < elements.length; i++) {
            elements[i] = rightArray[k];
            k++;
        }
        size++;

    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        List<E> s = (List<E>)c;
        elements = Arrays.copyOf(elements, size + s.size());//длина нашего массива + массива из элементов коллекции
        for (int i = 0; i < s.size(); i++) {

            elements[size++] = s.get(i);
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
