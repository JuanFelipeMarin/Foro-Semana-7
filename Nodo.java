
package foro7arboles;

public class Nodo {
     
    int clave;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        clave = valor;
        izquierda = derecha = null;
    }
}
