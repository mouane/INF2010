package MultiEnsemble;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Inspire par Bag.Java https://algs4.cs.princeton.edu/13stacks/
 */
public class Sac<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag

    // helper linked list class
    private static class Node<Item> {
    	public Node(Item item, Node<Item> next) {
    		this.next = next;
    		this.item = item;
    	}
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty bag.
     */
    public Sac() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this bag is empty.
     *
     * @return {@code true} if this bag is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this bag.
     *
     * @param  item the item to add to this bag
     */
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>(item, first);
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    /**
     * Unit tests the {@code Sac } data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Sac<Integer> sac = new Sac<Integer>();
        if (sac.isEmpty()) {
            System.out.print("Sac vide" + System.lineSeparator());
        }
        sac.add(20);
        sac.add(21);
        sac.add(22);
        sac.add(23);
        sac.add(24);
        for (Integer sacs : sac) {
            System.out.print(sacs + System.lineSeparator());
        }
        System.out.print("n elements " + sac.n + System.lineSeparator());
    }
}