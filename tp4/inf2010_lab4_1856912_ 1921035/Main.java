/*
 * Paul Clas 1846912 & Mazigh Ouanes 1921035
 * 16 Mars 2019
 * Main.java
 * Référence: 
 * https://github.com/phishman3579/java-algorithms-implementation/blob/master/src/com/jwetherell/algorithms/data_structures/BinaryHeap.java
 * https://stackoverflow.com/questions/7063909/heap-iterators-java
 * https://github.com/vitonimal
 * https://www.sanfoundry.com/java-program-implement-max-heap/
 * 
 */

package tp4;
import java.util.*; 


public class Main 
{
   /**
     * Fonction principale
     */
   public static void main(String[] args) 
   {
      // creer un monceau avec 22 elements et un tableau equivalent
      int numItems = 22;
      BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);
      
      Integer [ ] items = new Integer[ numItems ];

      int i;
      int j;

      // en inserant les elements un a un
      for( i = 11, j = 0; j != numItems; i = ( i + 37 ), j++ )
      {
	  heap.offer( i );
	  items[ j ] = i;

	  i %=  numItems; 
      }

      // en construisant le monceau depuis le depart
      System.out.println("Monceau min contruit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(false);
      // en inserant les elements un a un
      for( Integer item : items)
	  heap.offer( item );

      // en construisant le monceau depuis le depart
      System.out.println("Monceau max contruit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,false);
      System.out.println("Monceau max contruit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,true);
      System.out.println("Monceau min contruit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      System.out.println();
      System.out.println("Affichage recursif:");
      System.out.println( heap.printFancyTree() );

      System.out.println("Affichage non recursif:");
      System.out.println( heap.nonRecursivePrintFancyTree() );

      System.out.println();
      System.out.println("Tableau d'origine:");
      System.out.println( printArray( items ) );
      
      BinaryHeap.heapSort( items );
      System.out.println("Tableau ordonne:");
      System.out.println( printArray( items ) );

      BinaryHeap.heapSortReverse( items );
      System.out.println("Tableau inversement ordonne:");
      System.out.println( printArray( items ) );


      /*
       * Ajouter appels pour repondre a la question
       **/
     
      // test peek()

      System.out.println("\nPeek test min Heap: ");
      Integer peekE = heap.peek();
      System.out.println("Peek returned: " + peekE);
      System.out.println( heap.printFancyTree() );
      
      // Test offer()
      System.out.println("\nOffer Test :");
      boolean offer = heap.offer(11);
      System.out.println("Offer returner: " + offer);
      System.out.println( heap.printFancyTree());
      
      // test poll()

      System.out.println("\nPoll test min Heap: ");
      Integer pollE = heap.poll();
      System.out.println("Poll returned: " + pollE);
      System.out.println(heap.printFancyTree());

      

      // ITERATOR TEST

      System.out.println("\nheap_iterator test : ");
      Iterator<Integer> iterator = heap.iterator();
      while (iterator.hasNext()) {
          System.out.print(iterator.next() + " ");
      }
      System.out.println("\n");

      System.out.println("\nHeap iterator test (poll()): ");
      iterator = heap.iterator(); 	
      try {
	      while (iterator.hasNext()) {
	          System.out.print(iterator.next() + " ");
	          heap.poll();
	      }
      } catch (ConcurrentModificationException excep) {
    	  System.out.println("ConcurrentModificationException cought");
      }


      System.out.println("\nHeap iterator (offer()): ");

      iterator = heap.iterator(); 	
      try {
	      while (iterator.hasNext()) {
	          System.out.print(iterator.next() + " ");
	          heap.offer(11);
	      } 
      } catch (ConcurrentModificationException excep) {
    	  System.out.println("ConcurrentModificationException cought");

      }
      

   }

   private static <AnyType> 
   String printArray(AnyType[] a)
   {
      String outputString = "";
      for(AnyType item : a)
      {
         outputString += item;
         outputString += ", ";
      }
      return outputString.substring(0,outputString.length()-2);
   }
}
