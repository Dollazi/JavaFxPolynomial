/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

/**
 *
 * @author marco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        p.add(2, 0);
        p.add(4, 1);
        p.add(3, 2);
        System.out.println(p);
        System.out.println("Valor em x=1: " + p.valueAt(1));
        p.add(2, 2);
        System.out.println(p);
        System.out.println("Valor em x=1: " + p.valueAt(1));
        System.out.println(p);
        p.remove(0);
        System.out.println(p);
        
        Polynomial q = new Polynomial();
        q.add(-2, 0);
        q.add(1, 1);
        q.add(11, 5);
        System.out.println(q);
        
        // Soma de dois polinômios
        Polynomial r = Polynomial.sum(p, q);
        System.out.println(r);
    }
}
