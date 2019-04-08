package by.it.khlystunova.jd01_11;

import java.util.*;

/*TaskC. Свой SetC. Напишите класс SetC<T>, который реализует toString()как в HashSet
и 8 методов add(T e),remove(Object o), contains(Object o), size(), isEmpty(),
 addAll(List<?> c), containsAll(Collection<?> c),
 removeAll(Collection<?> c) интерфейса Set<T>(реализация остальных – фиктивная).*/

public class SetC<E> implements Set<E> {

    private E[] elements = (E[]) new Object[0];

    public int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E e) {
        if(this.contains(e))
            return false;
        if (size==elements.length)
            elements= Arrays.copyOf(elements, (size*3)/2+1);
        elements[size++]=e;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] a = (E[]) c.toArray();
        Collections.addAll(this, a);
        return true;
    }

    public E remove(int index) {
        E ret = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return ret;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return i;
            }
        } else
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }

        return -1;
    }

    @Override
    public boolean contains(Object o) {
        int i1 = indexOf(o);
        return i1 != -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if(!this.contains(o))
                return  false;
        }
        return  true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        E[] a = (E[]) c.toArray();
        for (E e : a) {
            this.remove(e);
        }
        return  true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }


    //stabs
    @Override
    public Spliterator<E> spliterator() {
        return null;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size=0;
        elements = Arrays.copyOf(elements, 0);
    }
}
