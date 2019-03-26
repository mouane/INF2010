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
	
	currentSize = items.length;
	int nb = 11/10;
	array= (AnyType[]) new Comparable [nb*(currentSize+2)];
	for(int i=0; i<items.length; i++) {
		this.array[i+1]=items[i]; // A verifier ??
	}

	
	// COMPLETEZ
	// invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min;
	if (min != true) {
		this.buildMaxHeap();
	}else this.buildMinHeap();
    }
    
    public boolean offer( AnyType x )
    {
	if (x == null)
	    throw new NullPointerException("Cannot insert null in a BinaryHeap");
	
	if( currentSize + 1 == array.length )
	    doubleArray();
	
	// COMPLETEZ


	if (min == true) {

		int hole = ++currentSize;

		for (; hole > 1 && x.compareTo(array[hole/2]) < 0 ; hole /=2)

				array [hole] = array [hole/2];

				array [hole] = x;

	}

	if (min == false) {

		int hole = ++currentSize;

		for (; hole > 1 && x.compareTo(array[hole/2]) > 0 ; hole /=2)

				array [hole] = array [hole/2];

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
    	if(min) {
    		percolateDownMinHeap(1,currentSize);
    	}else {
    		percolateDownMaxHeap(1,currentSize);
    	}
    	modifications++;
    	return array[1];
    }
    
    public Iterator<AnyType> iterator()
    {
	return new HeapIterator();
    }
   /***
    * 
    */
    private void buildMinHeap()
    {
	//COMPLETEZ
    	for(int i =currentSize/2; i>0;i--) {
    		percolateDownMinHeap(i,currentSize);//MIN
    	}
    }
    /**
     * 
     */
    private void buildMaxHeap()
    {
	//COMPLETEZ
    	for(int i =currentSize/2; i>0;i--) {
    		percolateDownMaxHeap(i,currentSize);//MAX
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
        AnyType temporaire = array[ hole ];

        for( ; hole*2 <= size; hole = child ){
            child =hole*2;

            if( child != size && array[child + 1].compareTo(array[child])>0) // >0
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
        AnyType temporaire = array[ hole ];

        for( ; hole * 2 <= size; hole = child ){
            child = hole * 2;

            if( child != size && array[child + 1].compareTo(array[child])<0)
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
            percolateDownMaxHeap(a, i, a.length-1, false);
        
    	
    	for( int i = a.length-1; i > 0; i-- ){
        	swapReferences(a,0,i);
        	percolateDownMaxHeap(a,0,i-1,false);}
    }
    /**
     * 
     * @param a
     */
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
	//COMPLETEZ
    	for( int i = a.length/2; i >= 0; i-- )  
            percolateDownMinHeap(a, i, a.length-1, false);
        
    	
    	for( int i = a.length-1; i > 0; i-- ){
    		swapReferences(a,0,i);
        	percolateDownMinHeap(a,0,i-1,false);}
    }
    
    public String nonRecursivePrintFancyTree()
    {
	String outputString = "";
	/******/
	Stack<Integer> index = new Stack<Integer>();
	index.push(1);
	Stack<String> prefix = new Stack<String>();
	index.push(1);
	prefix.push("");
	
	while(index.empty() == false) {
		int indexPile = index.pop();
		String prefixePile = prefix.pop();
		outputString += prefix + "|___";
		
		if(indexPile <=currentSize) {
			boolean feuille = indexPile >currentSize/2;
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
		
		return outputString;
	}

	
	//COMPLETEZ

	return outputString;
    }
    
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
	String outputString = "";
	
	outputString = prefix + "|__";
	
	if( index <= currentSize )
	    {
		boolean isLeaf = index > currentSize/2;
		
		outputString += array[ index ] + "\n";
		
		String _prefix = prefix;
		
		if( index%2 == 0 )
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
    	
    	int position = 0; //GLOBALE ?
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
		return position < currentSize;
		
    }

	public Object next() throws NoSuchElementException, 
				    ConcurrentModificationException, 
				    UnsupportedOperationException {
	    //COMPLETEZ
		
    	//int modif = modifications;
		/*if (m != modifications)
			throw new ConcurrentModificationException();
	
		if (isEmpty()) 
			throw new NoSuchElementException();
		
	    if (hasNext()) 
	    	return array[++position];
	    else 
	    	throw new UnsupportedOperationException();*/
	   
	    
	    if(!hasNext()){
            throw new NoSuchElementException();
        }

        if(m!= modifications){
            throw  new ConcurrentModificationException();
        }

        else{
            return array[position++];
        }
    
	    
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
