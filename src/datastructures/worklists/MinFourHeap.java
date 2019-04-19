package datastructures.worklists;

import egr221a.interfaces.worklists.PriorityWorkList;
import egr221a.exceptions.NotYetImplementedException;

import java.nio.BufferUnderflowException;
import java.util.NoSuchElementException;

/**
 * Author: Jacob J. Nona
 * Collaborated with: Alex P., Chase, Alex L., Robbie, Ryan B.
 * Partner: Isabel Ordaz
 * Java Class that implements the "heap" data structure using Generic Type Data.
 * Uses an array-based implementation beginning at index 0.
 * Each node contains 4 children for each tree.
 */
public class MinFourHeap<E extends Comparable<E>> extends PriorityWorkList<E> {
    private static final int DEFAULT_CAPACITY = 256;
    private E[] data;
    private int size;

    //Constructs class variables and initializes them accordingly
    public MinFourHeap() {
        data = (E[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    //method that contains a condition that checks for if the worklist has work
    @Override
    public boolean hasWork() {
        return size > 0;
    }

    /**
     * Pre: Conditions check the length to ensure increasing the size
     * Post:
     * - the "hole" to add in is set to the size
     * - the generic parameter is added to element as "hole" within the array
     * - size is incremented
     * - percolates upward
     * Override "add" method that
     * @param work
     */
    @Override
    public void add(E work) {
        if (size == data.length - 1) {
            enlarge();
        }

        int hole = size;
        data[hole] = work;
        size++;
        percolateUp(hole);
    }

    //Void method that enlarges the size of the array if the internal array runs out of space
    private void enlarge() {
        E[] old = data;
        data = (E[]) new Comparable[4 * old.length];
        for (int i = 0; i < old.length; i++)
            data[i] = old[i];
    }

    /**
     * private method that percolates up through the heap using the "hole" parameter with a generic value and a parentIndex
     * Pre: Condition checks the value of "hole" parameter and compares generic value with value at parentIndex in array
     * Post: "hole" index in array is set to parentIndex and then percolates upward after the value at the "hole" is set to "hole
     * @param hole
     */
    private void percolateUp(int hole) {
        E value = data[hole];

        int parentIndex = (hole - 1) / 4;

        while (hole > 0 && value.compareTo(data[parentIndex]) < 0) {
            data[hole] = data[parentIndex];

            hole = parentIndex;
            parentIndex = (hole - 1) / 4;

        }

        data[hole] = value;
    }

    //method that checks to worklist and returns the first value of the generic array
    @Override
    public E peek() {
        if (!hasWork()) {
            throw new NoSuchElementException();
        }
        return data[0];

    }

    //method that removes previous element and returns the next element.
    @Override
    public E next() {
        E minValue = peek();
        data[0] = data[--size];
        percolateDown(0);
        return minValue;

    }

    /**
     * private method that percolates up through the heap using the "hole" parameter with a generic value and a parentIndex
     * Pre:
     * - generic value and 4 children are initialized
     * - conditions compare each child to size and the values
     * - index is initialized
     * Post:
     * @param hole
     */
    private void percolateDown(int hole) {
        E value = data[hole];
        int leftChild = (4 * hole) + 1;
        int leftMidChild = leftChild + 1;
        int rightMidChild = leftMidChild + 1;
        int rightChild = rightMidChild + 1;
        while ((leftChild < size && value.compareTo(data[leftChild]) > 0) ||
                (leftMidChild < size && value.compareTo(data[leftMidChild]) > 0) ||
                (rightMidChild < size && value.compareTo(data[rightMidChild]) > 0) ||
                (rightChild < size && value.compareTo(data[rightChild]) > 0)) {

            int smallerIndex = leftChild;
            if (leftMidChild < size && (data[smallerIndex].compareTo(data[leftMidChild])) > 0) {
                smallerIndex = leftMidChild;
            }
            if (rightMidChild < size && (data[smallerIndex].compareTo(data[rightMidChild])) > 0) {
                smallerIndex = rightMidChild;
            }
            if (rightChild < size && (data[smallerIndex].compareTo(data[rightChild])) > 0) {
                smallerIndex = rightChild;
            }
            data[hole] = data[smallerIndex];
            hole = smallerIndex;
            leftChild = (4 * hole) + 1;
            leftMidChild = leftChild + 1;
            rightMidChild = leftMidChild + 1;
            rightChild = rightMidChild + 1;
        }
        data[hole] = value;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        data = null;
        size = 0;
    }
}
