package tp2;

import java.util.Random;
import java.util.ArrayList;

public class LinearSpacePerfectHashing<AnyType>
{
   static int p = 46337;
   
   int a, b, n, memorySize;
   QuadraticSpacePerfectHashing<AnyType>[] data;
   Random generator;
   
   LinearSpacePerfectHashing()
   {
      clear();
   }
   
   LinearSpacePerfectHashing(ArrayList<AnyType> array)
   {
      allocateMemory(array);
   }
   
   public void setArray(ArrayList<AnyType> array)
   {
      allocateMemory(array);
   }
   
   public int size()
   {
      return n;
   }

   public void clear()
   {
      generator = new Random( System.nanoTime() );
      a = b = n = memorySize = 0; 
      data = null;
   }

   private int findPos(AnyType x)
   {
	   int m=data.length;
	   int index = ( ( a*x.hashCode() + b ) % p ) % m;
	   int currentPos =( index < 0 ? index + m : index );
	   return currentPos;
   }
   
   public boolean contains(AnyType x)
   {      
      if(n==0) return false;
      int index = findPos(x);
      return ((data[index]!=null) && (data[index].contains(x)));
   }
 
   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array)
   {
      clear();
      
      if(array == null || array.size() == 0) return;

      n    = array.size();
      data = new QuadraticSpacePerfectHashing[n];
      
      if(n == 1)
      {
         // Completer
    	 clear();
    	 memorySize =2;
    	 data = new QuadraticSpacePerfectHashing[1];
    	 //data[0].items[0]= array.get(0);
         return;
      }
      
      // A completer
      a= generator.nextInt(p);
      b= generator.nextInt(p);
      
      ArrayList<AnyType>[] temporaire = new ArrayList[n];
      for(int i =0; i<n; i++) {
    	  temporaire[i] =new ArrayList<AnyType>();
      }
      int position;
      AnyType x;
      //memorySize =0;
      
      for(int i = 0; i<n; i++){
          x = array.get(i);
          position = findPos(x);
          temporaire[position].add(x);
          
       }

       for(int i = 0; i<n; i++){
          //(A) data[i] = new QuadraticSpacePerfectHashing<AnyType>(temporaire.get(i));
    	   //temporaire est alors defini comme ArrayList<AnyType> temporaire = new ArrayList<AnyType>()
          //(B) 
    	   data[i] = new QuadraticSpacePerfectHashing<AnyType>(temporaire[i]); 
          //Pourquoi cette expression n est elle pas equivalente si temporaire[i] etait defini
    	   //comme ArrayList<A
          memorySize += data[i].memorySize();
       }
 }
      
   public int memorySize() 
   {
      return memorySize;
   }
   
   public String toString(){
      StringBuilder sb = new StringBuilder();
      
      // completer
      for(int i = 0; i<n; i++){
          sb.append("- "+ i + " -> " + data[i].toString() + "\n");
 }
      
      return sb.toString();
   }
}
