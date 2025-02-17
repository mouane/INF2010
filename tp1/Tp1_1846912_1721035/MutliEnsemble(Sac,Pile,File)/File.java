package MultiEnsemble;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Inspire par Queue.Java https://algs4.cs.princeton.edu/13stacks/
 */
public class File<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
    	public Node(Item item) {
    		this.item = item;
    		next = null;
    	}
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queue.
     */
    public File() {
        first = null;
        last  = first;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("File est vide");
        return first.item;
    }

    /**
     * Adds the item to this queue.
     *
     * @param  item the item to add
     */
    public void enfile(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>(item);
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item defile() {
        if (isEmpty()) throw new NoSuchElementException("File est vide");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
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
     * Unit tests the {@code Queue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	File<Integer> file = new File<Integer>();
        if(file.isEmpty()) {
        	System.out.println("Sac Vide");
        }
        file.enfile(1);
        file.enfile(2);
        file.enfile(3);
        
        for(Integer files: file) {
        	System.out.println(files);
        }
        System.out.println("Element Defiler: " + file.defile());
        System.out.println("Element Enfiler: " + file.peek());
        
    }
}