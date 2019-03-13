/*
 * Paul Clas 1846912 & Mazigh Ouanes 1921035
 * 12 Mars 2019
 * BinarySearchNode.java
 */
package tp3;
import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data) {
    	this.data = data;
    	right = null;
    	left = null;

    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData() {
        return data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item) {
    	if (data.compareTo(item)<0) {
    		if (left == null)//left = new BinaryNode<T>(item);
    			left = new BinaryNode<T>(item);
    		else
    			left.insert(item);
    	}else {
    		if (right==null)//right.insert(item);
    			right = new BinaryNode<T>(item);
    		else
    			right.insert(item);
    	}
    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
    	if(item.compareTo(data)==0) {
    		return true;
    	}else if ((right != null)&& (data.compareTo(item)<0)){
    		return right.contains(item);
    	}
    	else if ((left != null)&& data.compareTo(item)>=0) {//else if ((left != null)&& data.compareTo(item)>=0) 
    		return left.contains(item);
    	}else {
    		return false;
    	}
        
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
    	int hG=-1, hD =-1;//hauteur de left hG et hauteur de right hD
    	
    	if( right!=null)
    		hD=right.getHeight();
    	if(left!=null)
    		hG=left.getHeight();
    	
    	if((left ==null)    && (right==null))
    		return 0;
    	
    	if(hG<hD)
    		return (++hD);
    	else
    		return (++hG);
    		

    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {

    	if(left==null) {
    		result.add(this);
    		if(right ==null)
    			return;
    		right.fillListInOrder(result);
    		return;
    	}
    	left.fillListInOrder(result); // euh ca marche ???
    	result.add(this);
    	if(right ==null) {
    		return;
    	}
    	right.fillListInOrder(result);
    	
    }
}
