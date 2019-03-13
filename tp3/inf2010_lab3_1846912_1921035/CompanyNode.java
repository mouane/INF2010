/*
 * Paul Clas 1846912 & Mazigh Ouanes 1921035
 * 12 Mars 2019
 * CompanyNode.java
 */
package tp3;
import java.util.List;

public class CompanyNode implements Comparable<CompanyNode> {
    private Integer money;
    private BinarySearchTree<CompanyNode> childs;
    public CompanyNode worstChild;

    // TODO: initialisation
    // O(1)
    public CompanyNode(Integer data) {
    	this.money = data;
    	worstChild = this;
    	childs = new BinarySearchTree <CompanyNode>(this);
    	
    	
    	

    }

    // TODO: la compagnie courante achete une autre compagnie
    // O(log(n))
    public void buy(CompanyNode item) {
    	money+=item.money;
    	childs.insert(item);
    	if(worstChild.compareTo(item.worstChild)>0)
    		worstChild =item.worstChild;

    }

    // TODO: on retourne le montant en banque de la compagnie
    // O(1)
    public Integer getMoney() {
        return money;
    }

    // TODO: on rempli le builder de la compagnie et de ses enfants avec le format
    //A
    // > A1
    // > A2
    // >  > A21...
    // les enfants sont afficher du plus grand au plus petit (voir TestCompany.testPrint)
    // O(n)
    public void fillStringBuilderInOrder(StringBuilder builder, String prefix) {
    	
    	/*
    	 * 
    	 * for(int i= orderedList.size() ;i >0; --i) {
    			builder.append(" > ");
    			fillStringBuilderInOrder(builder,prefix);
    			
    	 */
    	builder.append(this.getMoney() + "\n");
    	List<BinaryNode<CompanyNode>> orderedList = childs.getItemsInOrder();
    	
    	boolean vide = orderedList.isEmpty();// this.isEty();
    	
    	if(vide != false){
    		for(int i= orderedList.size() ;i >0; --i) {
    			builder.append(" > ");
    			fillStringBuilderInOrder(builder,prefix);
    			
    		}
    	}
    }

    // TODO: on override le comparateur pour defenir l'ordre
    @Override
    public int compareTo(CompanyNode item) {

        return money.compareTo(item.money);
    }
}
