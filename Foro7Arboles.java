
package foro7arboles;


public class Foro7Arboles {

 
      static void nodosMayoresQueValor(Nodo nodo, int valor) {
        if (nodo != null) {
            // Recorrido en preorden
            if (nodo.clave > valor) {
                System.out.print(nodo.clave + " ");
            }
            nodosMayoresQueValor(nodo.izquierda, valor);
            nodosMayoresQueValor(nodo.derecha, valor);
        }
    }

    static String postordenDesdePreInorden(String preorden, String inorden) {
        if (preorden.isEmpty() || inorden.isEmpty()) {
            return "";
        }

        char raizValor = preorden.charAt(0);
        int indiceRaizInorden = inorden.indexOf(raizValor);

        String postIzquierda = postordenDesdePreInorden(preorden.substring(1, indiceRaizInorden + 1), inorden.substring(0, indiceRaizInorden));
        String postDerecha = postordenDesdePreInorden(preorden.substring(indiceRaizInorden + 1), inorden.substring(indiceRaizInorden + 1));

        return postIzquierda + postDerecha + raizValor + " ";
    }
    
    public static void main(String[] args) {
        
         int valorDado = 70;
        String preorden = "GEAIBMCLDFKJH";
        String inorden = "IABEGLDCFMKHJ";

        Nodo raiz = construirArbol(preorden, inorden);

        System.out.println("Nodos mayores que " + valorDado + ":");
        nodosMayoresQueValor(raiz, valorDado);

        System.out.println("\nRecorrido en postorden:");
        System.out.println(postordenDesdePreInorden(preorden, inorden));
    }

    static int preIndex = 0;

    static Nodo construirArbol(String preorden, String inorden) {
        return construirArbolAux(preorden, inorden, 0, inorden.length() - 1);
    }

    static Nodo construirArbolAux(String preorden, String inorden, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        Nodo nodo = new Nodo(preorden.charAt(preIndex++));

        if (inStart == inEnd) {
            return nodo;
        }

        int inIndex = buscarIndice(inorden, inStart, inEnd, (char) nodo.clave);

        nodo.izquierda = construirArbolAux(preorden, inorden, inStart, inIndex - 1);
        nodo.derecha = construirArbolAux(preorden, inorden, inIndex + 1, inEnd);

        return nodo;
    }

    static int buscarIndice(String arr, int start, int end, char valor) {
        for (int i = start; i <= end; i++) {
            if (arr.charAt(i) == valor) {
                return i;
            }
        }
        return -1;
    }
    
    
}
