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


    public ListFIFOQueue() {
       front = null;
       end = null;
       size = 0;
    }

    @Override
    public void add(E work) {
        if (size == 0){
            front = new ListNode<>(work);
            end = front;
            size++;
        } else {
            end.next = new ListNode<>(work);
            end = end.next;
            size++;

        }
    }


    @Override
    public E peek() {
        if (size == 0){
            throw new NoSuchElementException();
        }
        return front.data;

    }

    @Override
    public E next() {
        if (size == 0){
            throw new NoSuchElementException();
        }
        E tempNext = front.data;
        front = front.next;
        size++;
        return tempNext;
    }

    @Override
    public int size() {
        return size;

    }

    @Override
    public void clear() {
        front = null;
        end = null;
        size = 0;
    }


    private static class ListNode<E> {
        public ListNode<E> next;
        public E data;

        public ListNode(){}

        public ListNode (E work){}
    }

}