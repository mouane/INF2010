/*
 * Paul Clas 1846912 & Mazigh Ouanes 1921035
 * 12 Mars 2019
 * CompanyTree.java
 */
package tp3;
public class CompanyTree {

    private CompanyNode root;

    public CompanyTree() { }

    // TODO: initialisation
    public CompanyTree(CompanyNode item) {
    	root =item;

    }

    // TODO: une compagnie mère achete une autre compagnie
    // O(n)
    public void buy(CompanyNode item) {
    	root.buy(item);

    }

    // TODO: on retourne le montant en banque de la compagnie mère
    // O(1)
    public Integer getMoney() {
        return root.getMoney();
    }

    // TODO: si on avait a laisser tomber un enfant, ça serait lui
    // Ceci est le pire de tous les enfants et les sous-enfants
    // O(1)
    public Integer getWorstChildMoney() {
        return root.worstChild.getMoney();
    }

    // TODO: on retourne en string un presentation en ordre inverse
    // de la compagnie mère et de ses enfants
    // O(1)
    public String getTreeInOrder() {
    	StringBuilder str = new StringBuilder();
    	String prefix = " ";
    	root.fillStringBuilderInOrder(str, prefix); // ou sinon juste faire "" a la place de prefixe
        return str.toString();
    }
}
