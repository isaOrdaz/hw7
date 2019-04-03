package datastructures.worklists;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.worklists.LIFOWorkList;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * See egr221a/interfaces/worklists/LIFOWorkList.java
 * for method specifications.
 */
public class ArrayStack<E> extends LIFOWorkList<E> {
    private E[] elements;
    private final int DEFAULT_SIZE = 10; //default capacity
    private int size;

    /**
     * This method initializes the array and size
     *
     * Post:
     *  - Array is initialized
     *  - Size is set to zero
     */
    public ArrayStack() {
        elements = (E[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * This method adds the passed in work and adds it
     * to the top of the array stack
     *
     * Post:
     *  - Work is added to the top of the stack
     *  - If the size of the array get to be a certain size
     *      bigger than array length, the array resize and
     *      copies the array
     * @param work
     */
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

    /**
     * This method returns the top of the stack
     * without removing it
     *
     * Pre:
     *  - Array must not be empty
     * Post:
     *  - Returns the top element without removing it
     * @return
     */
    @Override
    public E peek() {
        if(!hasWork()) {
            throw new NoSuchElementException();
        }

        return elements[size - 1];
    }

    /**
     * This method returns and removes the top element
     *
     * Pre:
     *  - The array can't be empty
     * Post:
     *  - Returns and removes the top element
     *  - Decrements the size by one
     * @return
     */
    @Override
    public E next() {
        if(!hasWork()) {
            throw new NoSuchElementException();
        }

        E removed = elements[size - 1];
        size--;

        return removed;
    }

    /**
     * This method returns the size of the array
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method resets the size to zero to
     * clear the array
     */
    @Override
    public void clear() {
        size = 0;
    }
}
