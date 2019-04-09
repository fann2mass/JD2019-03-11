package by.it.bildziuh.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T e) {
        if (this.contains(e))
            return false;
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        elements[size++] = e;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) remove(index);
        return (index > -1);
    }


    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] a = (T[]) c.toArray();
        Collections.addAll(this, a);
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        T[] a = (T[]) c.toArray();
        for (T e : a) {
            this.remove(e);
        }
        return true;
    }

    public T remove(int index) {  //спасибо Лизе
        T ret = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return ret;
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

