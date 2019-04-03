package datastructures.worklists;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.worklists.FIFOWorkList;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * See egr221a/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
    private ListNode<E> front;
    private ListNode<E> end;
    private int size;

    /**
     * This method initializes front, end,
     * and size to zero, zero, and null
     * respectively
     */
    public ListFIFOQueue() {
       front = null;
       end = null;
       size = 0;
    }

    /**
     * This method adds the work value
     * passed in to the queue
     *
     * Post:
     *  - If size is zero add work by creating a
     *      new node
     *  - If the queue is already populated work is
     *      added to the end
     * @param work
     */
    @Override
    public void add(E work) {
        if (size == 0){
            front = new ListNode<E>(work);
            end = front;
            size++;
        } else {
            end.next = new ListNode<E>(work);
            end = end.next;
            size++;

        }
    }


    /**
     * This method returns the data of the
     * front element
     *
     * Pre:
     *  - Queue should not be empty
     * Post:
     *  - Returns the data of the front
     *      element
     * @return
     */
    @Override
    public E peek() {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return front.data;

    }

    /**
     * This method returns and removes the front
     * element in the queue
     *
     * Pre:
     *  - The array should not be empty
     *
     * Post:
     *  - Removes the front element and
     *      returns it
     *  - Updates front to the next element
     * @return
     */
    @Override
    public E next() {
        if (size == 0){
            throw new NoSuchElementException();
        }
        E tempNext = front.data;
        front = front.next;
        size--;
        return tempNext;
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
     * This method clears the queue by
     * reinitializing front, end,
     * and size
     */
    @Override
    public void clear() {
        front = null;
        end = null;
        size = 0;
    }


    /**
     * This class is for a ListNode<E>
     * @param <E>
     */
    private static class ListNode<E> {
        public ListNode<E> next;
        public E data;





        public ListNode(){}


        public ListNode (E work){
            this.data = work;
        }
    }

}