/*
 * Paul Clas 1846912 & Mazigh Ouanes 1921035
 * 12 Mars 2019
 * Main.java
 */
package tp3;
// Toute modification a ce fichier ne sera pas comptabilisée
public class Main {

    // Le main fait simplement tester votre logique pour les deux exercices

    public static void main(String[] args) {
        System.out.println("Debut des tests du TP3");
        TestBinary testBinary = new TestBinary();
        testBinary.test();

        TestCompany testCompany = new TestCompany();
        testCompany.test();
    }
}
