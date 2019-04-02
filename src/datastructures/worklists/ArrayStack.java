package datastructures.worklists;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.worklists.LIFOWorkList;

import java.lang.reflect.Array;

/**
 * See egr221a/interfaces/worklists/LIFOWorkList.java
 * for method specifications.
 */
public class ArrayStack<E> extends LIFOWorkList<E> {
    private E[] elements;
    private final int DEFAULT_SIZE = 10;
    private int size;

    public ArrayStack() {
        elements = (E[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(E work) {
        elements[size] = work;
        size++;

        if(size > elements.length * .7){
            int tempSize = elements.length * 2;

            E[] temp = (E[]) new Object[tempSize];
            for(int i = 0; i < elements.length; i++){
                temp[i] = elements[i];
            }

            elements = temp;
        }
    }

    @Override
    public E peek() {
        if(!hasWork()) {
            throw new java.util.NoSuchElementException();
        }

        return elements[size - 1];
    }

    @Override
    public E next() {
        if(!hasWork()) {
            throw new java.util.NoSuchElementException();
        }

        return null;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public void clear() {
        for(int i = 0; i < elements.length; i++){
            elements[i] = null;
        }

        size = 0;
    }
}
