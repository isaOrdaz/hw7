package datastructures.dictionaries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.trie.BString;
import egr221a.interfaces.trie.TrieMap;

/**
 * See egr221a/interfaces/trie/TrieMap.java
 * and egr221a/interfaces/misc/Dictionary.java
 * for method specifications.
 */
public class HashTrieMap<A extends Comparable<A>, K extends BString<A>, V> extends TrieMap<A, K, V> {

    public class HashTrieNode extends TrieNode<Map<A, HashTrieNode>, HashTrieNode> {


        public HashTrieNode() {
            this(null);
            this.pointers = new HashMap<A, HashTrieNode>();
            size = 0;
        }

        public HashTrieNode(V value) {
            this.pointers = new HashMap<A, HashTrieNode>();
            this.value = value;
        }

        @Override
        public Iterator<Entry<A, HashTrieNode>> iterator() {
            return pointers.entrySet().iterator();
        }
    }

    public HashTrieMap(Class<K> KClass) {
        super(KClass);
        this.root = new HashTrieNode();
    }

    @Override
    public V insert(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Null parameter was detected.");
        }


        HashTrieNode current = (HashTrieNode) this.root;

        Iterator<A> iter = key.iterator();
        while (iter.hasNext()) {

            A character = iter.next();

            if (current.pointers.containsKey(character)) {
                current = current.pointers.get(character);
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
                //check to see if node is important: either has value or more than one character
                if (current.value != null || current.pointers.size() > 1) {
                    endNode = current;
                    nonParentNode = character;
                }
                current = current.pointers.get(character);
            } else { // path doesnt exist
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





    @Override
    public void clear() {
        root = null;
        size = 0;

    }
}

