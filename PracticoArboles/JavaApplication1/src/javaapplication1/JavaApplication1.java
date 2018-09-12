/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author alumnoFI
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ABB arbol1 = new ABB();
        ABB arbol2 = new ABB();
        
        arbol1.insertar(3);
        arbol1.insertar(1);
        arbol1.insertar(4);
        arbol1.insertar(6);
        arbol1.insertar(9);
        arbol1.insertar(2);
        arbol1.insertar(5);
        arbol1.insertar(7);
        arbol2.insertar(7);
        
        System.out.println("Arbol");
        arbol1.listarAscendente();
        System.out.println(" ");
        System.out.println("Cantidad de nodos");
        System.out.print(arbol1.cantNodos());
        System.out.println(" ");
        
        //arbol1.borrarMinimo();
        arbol1.listarAscendente();
        System.out.println(" ");
        //arbol1.borrarMinimo();
        arbol1.listarAscendente();
        
        System.out.println(" ");
        arbol2.listarAscendente();
        System.out.println(" ");
        arbol2.borrarMinimo();
        arbol2.listarAscendente();
        
    }
    
}
