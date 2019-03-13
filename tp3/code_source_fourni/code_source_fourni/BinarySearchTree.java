/*
 * Paul Clas 1846912 & Mazigh Ouanes 1921035
 * 12 Mars 2019
 * BinarySearchTree.java
 */
package tp3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/**
 * 
 * @author User
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<? super T> > {

    private BinaryNode<T> root;

    /*
     * 
     */
    public BinarySearchTree() { }

    // TODO: initialisation
    /*
     * 
     */
    public BinarySearchTree(T item) {
    	root = new BinaryNode<T>(item);

    }

    // TODO: on insere un nouvel item a partir de la racine
    // O(log(n))
    public void insert(T item) {
    	root.insert(item);

    }

    // TODO: est-ce qu'un item fais partie de l'arbre
    // O(log(n))
    public boolean contains(T item) {

        return root.contains(item);
    }

    // TODO: trouver la hauteur de l'arbre
    // O(n)
    public int getHeight() {
        return root.getHeight();
    }

    // TODO: placer dans une liste les items de l'arbre en ordre
    // O(n)
    public List<BinaryNode<T>> getItemsInOrder() {
        List<BinaryNode<T>> list = new ArrayList<BinaryNode<T>>();
        root.fillListInOrder(list);
        return list;
    }

    // TODO: retourner la liste d'item en String selon le bon format
    // O(n)
    public String toStringInOrder() {
    	String str = "[ "; //ne semble pas marcher
    	List<BinaryNode<T>> list =getItemsInOrder();
    	for(int i=0; i<list.size();++i) {
    		str+= list.get(i).getData().toString(); // list.getData(i).toString() ???
    		if(i!=list.size()-1) {
    			str+= " , ";
    		}
    		//str+=" ]";
    	}
    	str+=" ]";
    	
        return str;
    }
}
