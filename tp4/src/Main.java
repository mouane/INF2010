import java.util.*; 

@SuppressWarnings("unused")
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
      
      System.out.println();
      System.out.println("Test Pool (Retirer la Racine):"); //On enleve 11
      System.out.println();
      heap.poll();
      System.out.println( heap.printFancyTree() );
      System.out.println();
      
      System.out.println("Test Offer ():"); //On rajoute 11
      System.out.println();
      heap.offer(11);
      System.out.println( heap.printFancyTree() );
      System.out.println();
      
      System.out.println("Test No Such Element:");
      System.out.println();
      heap.clear();
      Iterator<Integer> iterateur = heap.iterator();
      iterateur.next();
      System.out.println();

      
      System.out.println("Test Concurrent Modification Exception:");
      System.out.println();
      Iterator<Integer> iterateur1 = heap.iterator();
      while (iterateur1.hasNext()) {
    	  heap.offer(10);
    	  iterateur1.next();
      }

      
      System.out.println("Test Unsupported Operation Exception:");
      Iterator<Integer> iterateur11 = heap.iterator();
      while (iterateur11.hasNext()) {
	  iterateur11.next();
      }
      iterateur11.next();
      
      
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
