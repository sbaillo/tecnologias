/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Set;

/**
 *
 * @author alumnoFI
 */
public class ABB {

    NodoABB raiz;

    public NodoABB getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoABB raiz) {
        this.raiz = raiz;
    }

    public ABB() {
        this.raiz = null;
    }

    public void listarAscendente() {

        listarAscendente(this.raiz);
    }

    //-----------------------------------------------
    //Practico 3e
    //In Order - Para cambiar a pre o post order cambiar la posicion donde se hace el System.out.print
    public void listarAscendente(NodoABB nodo) {

        if (nodo != null) {
            listarAscendente(nodo.getIzq());
            System.out.print(nodo.getDato());
            System.out.print(" ");
            listarAscendente(nodo.getDer());
        }
    }

    //---------------------------------------------
    //practico 1a
    public int cantNodos() {
        return cantNodos(this.raiz);
    }

    public int cantNodos(NodoABB nodo) {
        int cant = 0;
        if (nodo != null) {
            cant += cantNodos(nodo.getIzq());
            cant++;
            cant += cantNodos(nodo.getDer());
        }

        return cant;
    }

    //-----------------------------------------------
    //practico 1b
    public int cantHojas() {
        return cantHojas(this.raiz);
    }

    public int cantHojas(NodoABB nodo) {
        int cant = 0;
        if (nodo != null) {
            cant += cantHojas(nodo.getIzq());
            if (nodo.getIzq() == null && nodo.getDer() == null) {
                cant++;
            }
            cant += cantHojas(nodo.getDer());
        }

        return cant;
    }

    //Otra forma - Pone los 2 casos bases primero
    public int cantHojas2(NodoABB nodo) {
        if (nodo == null) {
            return 0;
        } else if (nodo.getIzq() == null && nodo.getDer() == null) {
            return 1;
        } else {
            return cantHojas2(nodo.getIzq()) + cantHojas2(nodo.getDer());
        }
    }

    //-----------------------------------------------
    //practico 1e
    public boolean todosPares() {
        return todosPares(this.raiz);
    }

    public boolean todosPares(NodoABB nodo) {
        //caso base 1 . No tiene que llamarse recursivo
        if (nodo == null) {
            return true;
        }

        //caso base 2 
        if (nodo.getDato() % 2 != 0) {
            return false;
        }

        return todosPares(nodo.getIzq()) && todosPares(nodo.getDer());
    }

    //-------------------------------------------------
    //Practico 3a
    public void insertar(int x) {
        this.raiz = insertar(x, this.raiz);
    }

    public NodoABB insertar(int x, NodoABB nodo) {
        if (nodo == null) {
            return new NodoABB(x);
        } else if (x < nodo.getDato()) {
            nodo.setIzq(insertar(x, nodo.getIzq()));
            return nodo;
        } else if (x > nodo.getDato()) {
            nodo.setDer(insertar(x, nodo.getDer()));
            return nodo;
        }

        return null;
    }

    //-------------------------------------------------
    //Practico 3b
    public void borrarMinimo() {
        borrarMinimo(this.raiz);
    }

    //No anda bien del todo cuando el arbol tiene un solo elemento o no tiene elementos a la derecha
    public void borrarMinimo(NodoABB nodo) {
        NodoABB aux = nodo;

        if (aux != null) {

            if (aux.getIzq() == null) {
                aux = aux.getDer();
            } 
            else 
            {
                while (aux.getIzq().getIzq() != null) {
                    aux = aux.getIzq();
                }

                if (aux.getIzq().getDer() == null) {
                    aux.setIzq(null);
                } else {
                    aux.setIzq(aux.getIzq().getDer());
                }
            }
        }
    }

}
