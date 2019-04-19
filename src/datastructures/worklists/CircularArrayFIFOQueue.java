package datastructures.worklists;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.worklists.FixedSizeFIFOWorkList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by: Jacob Nona & Isabel Ordaz
 * Collaborated with: Alex L., Grayson, Robbie, Chase, Alex P.
 * Program for creating a circular array as a queue under the hood which extends from its parent's class
 * Uses worklists methods provided to construct the functions for the data structure
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
    private E[] circleQueue;
    private int first;
    private int index;
    private int size;

    //Constructs the parameter for capacity and the class variables
    public CircularArrayFIFOQueue(int capacity) {
        super(capacity);
        size = 0;
        circleQueue = (E[]) new Object[capacity];
        index = 0;
        first = 0;
    }

    /**
     * method that adds the given generic value to the worklist
     * Pre: size is compared to capacity to ensure no index exceptions
     * Post: work value is set to the element at the index within the array
     * index is moved using modular operations to ensure that the index stays within bounds
     * size is incremented
     * @param work
     * the work to add to the worklist
     */
    @Override
    public void add(E work) {
        if (size < capacity()) {
            circleQueue[index] = work;
            index = (1 + index) % circleQueue.length;
            size++;
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * method that returns the first element within the circular array (worklist)
     * only can be applied when work is available
     * @return
     */
    @Override
    public E peek() {
        if(!hasWork()) {
            throw new NoSuchElementException();
        }
        return circleQueue[first];
    }

    /**
     * method that returns the ith element within the circular array (worklist)
     * only can be applied when work is available
     */
    @Override
    public E peek(int i) {
        if(!hasWork()) {
            throw new NoSuchElementException();
        }
        return circleQueue[(first + i) % circleQueue.length];
    }

    /**
     * This method removes and returns the
     * first element
     *
     * Pre:
     *  - Array must not be empty
     * Post:
     *  - Removes the first element in the queue
     *      and returns it
     *  - Updates first to be the next element in the
     *      queue
     * @return
     */
    @Override
    public E next() {
        if(!hasWork()) {
            throw new NoSuchElementException();
        }
        E temp = circleQueue[first];
        if (temp != null) {
            circleQueue[first] = null;
            first = (1 + first) % circleQueue.length;
            size--;
        }
        return temp;
    }

    /**
     * This method reassigns the ith element to
     * the value passed in
     * @param i
     *            the index of the element to update
     * @param value
     */
    @Override
    public void update(int i, E value) {
        if (size > 0)
            circleQueue[(first + i) % circleQueue.length] = value;

    }

    /**
     * This method returns the size of
     * the queue
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method clears the array
     * by reinitializing first, index,
     * and size to zero
     */
    @Override
    public void clear() {
        first = 0;
        index = 0;
        size = 0;
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
        } else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
            return false;
        } else {
            FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

            // Your code goes here

           if (this.size == other.size()){
               Iterator<E> iter1 = this.iterator();
               Iterator<E> iter2 = other.iterator();
               while(iter1.hasNext() && iter2.hasNext()){
                   if (!iter1.next().equals(iter2.next())){
                       return false;
                   }
               }
               return !iter1.hasNext() && !iter2.hasNext();
           }
        }
        return false;
    }



    @Override
    public int hashCode() {
        // You will implement this method in p2. Leave this method unchanged for p1.
        int hash = 0;
        for (E item: this){
            hash /= this.size;
            hash += 23 * item.hashCode();
        }

        return hash;
    }
}
