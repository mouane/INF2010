/*
 * Paul Clas 1846912 & Mazigh Ouanes 1921035
 * 16 Mars 2019
 * BinaryHeap.java
 */
package tp4;
import java.util.*; 


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType>
{
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType [ ] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications;    // Nombre de modifications apportees a ce monceau
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( boolean min )
    {
	this.min = min;
	currentSize = 0;
	array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( AnyType[] items, boolean min )
    {
	this.min = min;
	int i = 1;
	currentSize = items.length;
	//int nb = 11/10;
	array= (AnyType[]) new Comparable [currentSize+1];
	/*for(int i=0; i<items.length; i++) {
		this.array[i+1]=items[i]; // A verifier ??
	}*/
	
	for(AnyType item : items) {
		array[i++] = item;
	}
	
	// COMPLETEZ
	// invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min;
	/*if (min != true) {
		buildMaxHeap();
	}else buildMinHeap();
    }*/
	
	if(min == true)
		buildMinHeap();
	else buildMaxHeap();
    
    }
    
    public boolean offer( AnyType x )
    {
	if (x == null)
	    throw new NullPointerException("Cannot insert null in a BinaryHeap");
	
	if( currentSize + 1 == array.length )
	    doubleArray();
	
	// COMPLETEZ


	int hole = ++currentSize;
// pour max
	if (min == false) {
		//int hole = ++currentSize;
		for (; hole > 1 && x.compareTo(array[hole/2]) > 0 ; hole /=2) {
				array [hole] = array [hole/2];
				}
		array [hole] = x;

	}
	
	if (min == true) {
		//int hole = ++currentSize;
		for (; hole > 1 && x.compareTo(array[hole/2]) < 0 ; hole /=2) {
				array [hole] = array [hole/2];}
		array [hole] = x;
		

	}
	
	modifications++;
	return true;
    }
    
    public AnyType peek()
    {
	if(!isEmpty())
	    return array[1];
	
	return null;
    }
    
    public AnyType poll()
    {
	//COMPLETEZ
    	array[1]= array[currentSize--];
    	if(!min) {
    		percolateDownMaxHeap(1,currentSize);
    	}else {
    		percolateDownMinHeap(1,currentSize);
    	}
    	modifications++;
    	return array[1];
    }
    
    public Iterator<AnyType> iterator()
    {
	return (Iterator<AnyType>) new HeapIterator();
    }
   /***
    * 
    */
    private void buildMinHeap()
    {
	//COMPLETEZ
    	for(int i =currentSize/2; i>0;i--) {
    		percolateDownMinHeap(i,currentSize);
    	}
    }
    /**
     * 
     */
    private void buildMaxHeap()
    {
	//COMPLETEZ
    	for(int i =currentSize/2; i>0;i--) {
    		percolateDownMaxHeap(i,currentSize);
    		}
    
    }
    
    public boolean isEmpty()
    {
	return currentSize == 0;
    }
    
    public int size()
    {
	return currentSize;
    }
    
    public void clear()
    {
	currentSize = 0;
	modifications = 0;
	array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    private static int leftChild( int i, boolean heapIndexing )
    {
	return ( heapIndexing ? 2*i : 2*i+1 );
    }
    
    private void swapReferences( int index1, int index2 )
    {
	swapReferences(array, index1, index2);
    }
    /**
     * 
     * @param array
     * @param index1
     * @param index2
     */
    private static <AnyType extends Comparable<? super AnyType>>
				    void swapReferences( AnyType[] array, int index1, int index2 )
    {
	AnyType tmp = array[ index1 ];
	array[ index1 ] = array[ index2 ];
	array[ index2 ] = tmp;
    }
    
    @SuppressWarnings("unchecked")
	private void doubleArray()
    {
	AnyType [ ] newArray;
	
	newArray = (AnyType []) new Comparable[ array.length * 2 ];
	for( int i = 0; i < array.length; i++ )
	    newArray[ i ] = array[ i ];
	array = newArray;
    }
    
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMinHeap( int hole, int size )
    {
	percolateDownMinHeap(array, hole, size, true);
    }
    
    /**
     * @param array   Tableau d'element
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
	//COMPLETEZ
    	
    	int child;
        AnyType temporaire;

        for( temporaire= array[ hole ] ; leftChild( hole, true ) < size; hole = child ){
            child =leftChild( hole , true);

            if( child != size-1 && array[child + 1].compareTo(array[child])>0) // >0
                 child++;

            if( array[child].compareTo( temporaire )   > 0 ) //>0
                array[hole] = array[ child ];
            else
                break;
        }
        array[ hole ] = temporaire;
    }
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size )
    {
	percolateDownMaxHeap(array, hole, size, true);
    }
    
    /**
     * @param array         Tableau d'element
     * @param hole          Position a percoler
     * @param size          Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>> 
				    void percolateDownMaxHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
	//COMPLETEZ
     	int child;
        AnyType temporaire;

        for(temporaire = array[hole] ; leftChild( hole, true ) < size; hole = child ){
            //child = hole * 2;
        	child = leftChild( hole , true);

            if( child != size-1 && array[child + 1].compareTo(array[child])<0)
                child++;

            if( array[ child ].compareTo( temporaire ) < 0 )
                array[ hole ] = array[ child ];
            else
                break;
        }
        array[ hole ] = temporaire;
    	
    }
    /**
     * 
     * @param a
     */
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    {
	//COMPLETEZ
    	for( int i = a.length/2; i >= 0; i-- )  
            percolateDownMaxHeap(a, i, a.length, true);
        
    	
    	for( int i = a.length-1; i > 0; i-- ){
        	swapReferences(a,0,i);
        	percolateDownMaxHeap(a,0,i,true);}
    }
    /**
     * 
     * @param a
     */
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
	//COMPLETEZ
    	for( int i = a.length/2-1; i >= 0; i-- )  
            percolateDownMinHeap(a,i, a.length, true);
        
    	
    	for( int i = a.length-1; i > 0; i-- ){
    		swapReferences(a,0,i);
        	percolateDownMinHeap(a,0,i,true);}
    }
    
    public String nonRecursivePrintFancyTree()
    {
	/*String outputString = "";
	Stack<Integer> index = new Stack<Integer>();
	//index.push(1);
	Stack<String> prefix = new Stack<String>();
	index.push(1);
	prefix.push(outputString);
	boolean feuille = false;
	
	while(index.empty() == false) {
		
		int indexPile = index.pop();
		String prefixePile = prefix.pop();
		outputString += prefix + "|___";
		
		if(indexPile <=currentSize) {
			feuille = indexPile >currentSize/2;
			outputString += array[indexPile]+ "\n";
			String p = prefixePile;
			if(indexPile%2 != 0) {
				p += "    ";
			}else  p += "|   ";
			
			if (!feuille) {
				index.push(2*indexPile+1);
				prefix.push(p);
				index.push(2*indexPile);
				prefix.push(p);
				//outputString += printFancyTree( 2*indexPile, p);
				//outputString += printFancyTree( 2*indexPile + 1, p);
			}
			
			
		}else outputString += "    \n";
		
		return outputString;*/
    	
    	int index = 1;
        if (array[index] == null) {    // S'il est vide, cas de base
            return " Is empty"; 
        } 
        String outputString = "";
        
        Stack<Integer> indexStack = new Stack<Integer>(); 
        Stack<String> spacingStack = new Stack<String>();
        
        boolean leafToNode = false;
        indexStack.push(index); 
        spacingStack.push(outputString);
  
        while (indexStack.empty() == false) { 
        	String spacing = spacingStack.peek();
        	index = indexStack.peek(); // Dernier item sur le stack
    
        	int leftIndex = leftChild(index, true);
        	int rightIndex = leftIndex + 1;
        	
        	if(leafToNode == true) { 
        		spacingStack.pop();
        		leafToNode = false;
        	}
        	outputString += spacing + "|__";
        	
        	if(index <= currentSize) {
        		boolean isLeaf = index > currentSize/2;
        		
	        	outputString += array[index]  + "\n";
	        	indexStack.pop(); 
	            
	    		if(index % 2 == 0) {
	    		    spacing += "|  "; 
	    		    spacingStack.push(spacing);
	    		}
	    		
	    		else {
	    		    spacing += "   " ;
	    		    spacingStack.push(spacing);
	    		}
	    		
	            if(!isLeaf){ 
	        	   indexStack.push(rightIndex); // Child_Droite
	        	   indexStack.push(leftIndex);  // Child_Gauche
	           }
	            else {
	            	spacingStack.pop();
	            	leafToNode = true;
	           
	            }
	        } //if
        	else {
        		outputString += "null\n";
        		indexStack.pop();
        	}
        	
        }//while
    
    return outputString;
	}

	
	/*//COMPLETEZ

	return outputString;
    }*/
    
    public String printFancyTree()
    {
	return printFancyTree(1, "");
    }
    /***
     * 
     * @param index
     * @param prefix
     * @return
     */
    private String printFancyTree( int index, String prefix)
    {
	/*String outputString = "";
	
	outputString = prefix + "|__";
	
	if( index <= currentSize )
	    {
	
		boolean feuille = index > currentSize/2;
		
		outputString += array[ index ] + "  \n";
		
		String p = prefix;
		
		if( index%2 != 0 )
			p += "   ";
		else
			prefix += "|  "; 
		
		if( !feuille ) {
		    outputString += printFancyTree( 2*index, p);
		    //? 
		    // ?
		    outputString += printFancyTree( 2*index + 1,p );
			}
	    }
	else
	    outputString += "     \n";
	*/
		String outputString = "";
		
		outputString = prefix + "|__";
		
		if( index <= currentSize )
		    {
			boolean isLeaf = index > currentSize/2;
			
			outputString += array[ index ] + "\n";
			
			String _prefix = prefix;
			
			if( index % 2 == 0 )
			    _prefix += "|  "; // un | et trois espace
			else
			    _prefix += "   " ; // quatre espaces
			
			if( !isLeaf ) {
			    outputString += printFancyTree( 2*index, _prefix);
			    outputString += printFancyTree( 2*index + 1, _prefix);
			}
		    }
		else
		    outputString += "null\n";
	
	return outputString;
    }
    
    private class HeapIterator implements Iterator {
    	
    	int index = 0; //GLOBALE ?
    	int m = modifications;
	
	public boolean hasNext() {
	    //COMPLETEZ
		//return false;
		//return position != currentSize;
		//boolean answ;
		/*for(int i = 0; i < currentSize; i++)
        {
            if(array[i] != null)
    
                return true;
            
            else 
            	return false;
        }*/
		//return position != currentSize;
		if(index >= currentSize){
			return false;
		}
		else{
			return true;
		}
		
    }

	public Object next() throws NoSuchElementException, 
				    ConcurrentModificationException, 
				    UnsupportedOperationException {
	    //COMPLETEZ
		
    	//int modif = modifications;
		if (m != modifications)
			throw new ConcurrentModificationException();
	
		//if (isEmpty()) 
			//throw new NoSuchElementException();
		
	    if (hasNext()) 
	    	return array[index++];
	    else 
	    	throw new UnsupportedOperationException();
	   
	    
	    /*if(!hasNext()){
            throw new NoSuchElementException();
        }

        if(m!= modifications){
            throw  new ConcurrentModificationException();
        }

        else{
            return array[position++];
        }*/
    
	    
	    /*ArrayList<AnyType> list = new ArrayList<AnyType>(); 
        for(int i = 0; i< array.length; i++){
            list.add(array[i]);
        }
            Iterator<AnyType> iterator = list.iterator();
            int modif = modifications;
            while (iterator.hasNext()) {
                if (modif != modifications) {
                    throw new ConcurrentModificationException();
                }
                modif++;
                iterator.next();
            }
return iterator;

*/
	}
	
	public void remove() {
	    throw new UnsupportedOperationException();
	}
   }
}
