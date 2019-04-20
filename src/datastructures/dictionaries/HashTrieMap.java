package datastructures.dictionaries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.trie.BString;
import egr221a.interfaces.trie.TrieMap;

/**
 *
 * Author: Jacob J. Nona
 * Collaborated with: Alex P., Chase, Alex L., Robbie, Ryan B.
 * Partner: Isabel Ordaz
 * Java Class that uses an implementation of a trie where the "pointers" consist of a HashMap.
 * Program accepts a string and creates a trie that creates nodes for each character
 *
 */
public class HashTrieMap<A extends Comparable<A>, K extends BString<A>, V> extends TrieMap<A, K, V> {

    public class HashTrieNode extends TrieNode<Map<A, HashTrieNode>, HashTrieNode> {

        //Constructs a value for nodes
        public HashTrieNode() {
            this(null);
            this.pointers = new HashMap<A, HashTrieNode>();
            size = 0;
        }

        //Constructs the root and refers to superclass method
        public HashTrieNode(V value) {
            this.pointers = new HashMap<A, HashTrieNode>();
            this.value = value;
        }


        @Override
        public Iterator<Entry<A, HashTrieNode>> iterator() {
            return pointers.entrySet().iterator();
        }
    }
    //Constructs root node and calls superclass method
    public HashTrieMap(Class<K> KClass) {
        super(KClass);
        this.root = new HashTrieNode();
    }

    /**
     * method that returns a generic type and associates the given value with the given key
     * Pre: Condition checks for if the given key contains characters
     * - key and value are checked for null values
     * Post: current is initialized and passes by every character within the given key through the trie
     *
     * @param key
     *            key with which the specified value is to be associated
     * @param value
     *            value to be associated with the specified key
     * @return
     */
    @Override
    public V insert(K key, V value) {
        //case 1: Parameters are null
        if (key == null || value == null) {
            throw new IllegalArgumentException("Null parameter was detected.");
        }


        HashTrieNode current = (HashTrieNode) this.root;

        Iterator<A> iter = key.iterator();
        //case 2: The node has children
        while (iter.hasNext()) {

            A character = iter.next();

            if (current.pointers.containsKey(character)) {
                current = current.pointers.get(character); //current traverses through the trie
            } else {
                current.pointers.put(character, new HashTrieNode(null));
                current = current.pointers.get(character);
            }


        }

        V tempValue = current.value;
        if (tempValue == null) {
            size++;
        }
        current.value = value;
        return tempValue;


    }

    /**
     * method that returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     * Pre: Condition checks for if given key is null
     * Post: current is initialized and iteration is used to traverse through the trie
     * @param key
     * the key whose associated value is to be returned
     * @return
     */
    @Override
    public V find(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Null parameter was detected.");
        }


        HashTrieNode current = (HashTrieNode) this.root;
        for (A character : key) {
            if (current.pointers.containsKey(character)) {
                current = current.pointers.get(character);
            } else {
                return null;
            }
        }

        return current.value;
    }

    /**
     * method that returns true if this map contains a mapping for which the key starts with the specified key prefix.
     * Pre: Condition checks for if given key is null
     * Post: Current is initialized and iteration is used to traverse through the trie
     * @param key
     * @return
     */
    @Override
    public boolean findPrefix(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Null parameter was detected.");
        }

        HashTrieNode current = (HashTrieNode) this.root;

        for (A character : key) {
            if (current.pointers.containsKey(character)) {
                current = current.pointers.get(character);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * method that removes the mapping for the specified key from this map if present.
     * Pre: Condition checks for if given key is null
     * Post:
     * - current, endNode, and the nonParentNode are initialized.
     * - Utilized iteration to move through each character within key
     * - cases for null values, greater than 1 sizes, and
     * @param key
     *            key whose mapping is to be removed from the map
     */
    @Override
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Null parameter was detected.");
        }
        HashTrieNode current = (HashTrieNode) this.root;
        HashTrieNode endNode = (HashTrieNode) this.root;
        A nonParentNode = null;


        for (A character : key) { // iterates through the characters of the key
            if (current.pointers.containsKey(character)) { // condition that checks if there is a path of characters present

                if (nonParentNode == null){
                    nonParentNode = character;
                }
                //
                if (current.value != null || current.pointers.size() > 1) {
                    endNode = current;
                    nonParentNode = character;
                }
                current = current.pointers.get(character);
            } else { // data not within worklist
                return;
            }
        }
        if (current.value != null) {size--;}
        if (current.pointers.size() > 0) {
            current.value = null;
        } else {
            endNode.pointers.remove(nonParentNode);
        }
    }




    //clears class variables and sets them as their original states
    @Override
    public void clear() {
        root = null;
        size = 0;

    }
}

