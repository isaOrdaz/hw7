package datastructures.worklists;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.worklists.FixedSizeFIFOWorkList;

/**
 * See egr221a/interfaces/worklists/FixedSizeLIFOWorkList.java
 * for method specifications.
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
    private E[] array;
    private int index;

    public CircularArrayFIFOQueue(int capacity) {
        super(capacity);



    }

    @Override
    public void add(E work) {
        if (capacity() >= 0) {
            array[index] = work;
            index++;
            }
        }


    @Override
    public E peek() {
       return array[index];
    }
    
    @Override
    public E peek(int i) {
        return array[index + i];
    }
    
    @Override
    public E next() {
        E temp = array[index];
        if (temp != null){
            array[index] = null;
            index++;
        }
       return temp;
    }
    
    @Override
    public void update(int i, E value) {
       if (array != null)
           array[i] = value;

    }
    
    @Override
    public int size() {

    }
    
    @Override
    public void clear() {
        throw new NotYetImplementedException();
    }

    @Override
    public int compareTo(FixedSizeFIFOWorkList<E> other) {
        // You will implement this method in p2. Leave this method unchanged for p1.
        throw new NotYetImplementedException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        // You will finish implementing this method in p2. Leave this method unchanged for p1.
        if (this == obj) {
            return true;
        }
        else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
            return false;
        }
        else {
            FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

            // Your code goes here

            throw new NotYetImplementedException();
        }
    }

    @Override
    public int hashCode() {
        // You will implement this method in p2. Leave this method unchanged for p1.
        throw new NotYetImplementedException();
    }
}
