package implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import trees.SortedSet;

public class Binarysearchtree<T extends Comparable<? super T>> implements SortedSet<T> {
    
    private class Node {
        T value;
        Node left;
        Node rigth;

        public Node(T x){
            this.value = x;
        }
    }
    private Node root;
    private int size;

    public boolean add(T x){
        if(root == null){
            root = new Node(x);
            size ++;
            return true;
        }

        return addRec(root, x);
    }

    private boolean addRec(Node node, T x){
        int cmp = x.compareTo(node.value);

        if(cmp == 0) return false;
        if(cmp < 0){
            if(node.left == null){
                node.left = new Node(x);
                size++;
                return true;
            }
            return addRec(node.left, x);
        } else {
            if(node.rigth == null){
                node.rigth = new Node(x);
                size++;
                return true;
            }
            return addRec(node.rigth, x);
        }

    }
    
    public boolean remove(T x){
        if(root == null){
            return false;
        }
        int oldSize = size;
        root  = removeRec(root, x);
        return size < oldSize; // si da true, se elimino correctamente. Sino, no se encontro el elemento o arbol vacio.
        
    }

    private Node removeRec(Node nodo, T x){
        if(nodo == null){
            return null; // caso cuando no se encuentra el elemento.
        }

        int cmp = x.compareTo(nodo.value);

        if(cmp < 0){
            nodo.left = removeRec(nodo.left, x);
        } else {
            if(cmp > 0){
                nodo.rigth = removeRec(nodo.rigth, x);
            } else {
                //caso 1:: No tiene hijos
                if(nodo.left == null && nodo.rigth == null){
                    size--;
                    return null;
                }

                if(nodo.left == null && nodo.rigth != null){
                    nodo.value = nodo.rigth.value;
                    nodo.rigth = removeRec(nodo.rigth, nodo.value);
                    return nodo;
                }
                if(nodo.left != null && nodo.rigth == null){
                    nodo.value = nodo.left.value;
                    nodo.left = removeRec(nodo.left, nodo.value);
                    return nodo;
                }

                if(nodo.left != null && nodo.rigth != null){
                    Node minDer = minSubarbolDer(nodo.rigth);
                    nodo.value = minDer.value;
                    nodo.rigth = removeRec(nodo.rigth, nodo.value);
                    return nodo;
                }
            }
        }

        return nodo;

    }

    /**
     * 
     * @param nodo.rigth
     * @return nodo minimo.
     */
    private Node minSubarbolDer(Node nodo){
        if(nodo.left == null) return nodo;
        return minSubarbolDer(nodo.left);
    }

    public boolean contains(T x){
        if (root == null) return false;
        T aux = containsRec(root, x).value;
        
        if(x.compareTo(aux) == 0) return true;

        return false;
    }

    private Node containsRec(Node nodo, T x){
        int cmp = x.compareTo(nodo.value);
       
        if(cmp == 0)return nodo;
        if(cmp < 0) {
            return containsRec(nodo.left, x);
        } else {
            return containsRec(nodo.rigth, x);
        }
    }

    public int size(){
        return size;
    }

    public T min(){
        if(root == null){
            throw new NoSuchElementException("El arbol esta vacio");
        }
        return minRec(root);
    }

    private T minRec(Node nodo){
        if(nodo.left == null){
            return nodo.value;
        } else {
            return minRec(nodo.left);
        }
    }

    public T max(){
        if(root == null){
            throw new NoSuchElementException("El arbol esta vacio");
        }

        Node nodo = root;

        while(nodo.rigth != null){
            nodo = nodo.rigth;
        }

        return nodo.value;
    }

    public void removeMin(){
        if(root == null){
            throw new NoSuchElementException("El arbol esta vacio");
        }
        root = removeMinRec(root);
    }

    private Node removeMinRec(Node nodo){
        if(nodo.left == null){
            return nodo.rigth; // reemplaza al nodo minimo.
        }
        nodo.left = removeMinRec(nodo.left);
        return nodo;
    }

    public void removeMax(){
        if(root == null){
            throw new NoSuchElementException("El arbol esta vacio"); 
        }
    
        root = removeMaxRec(root);
    }

    private Node removeMaxRec(Node nodo){
        if(nodo.rigth == null){
            return nodo.left;
        }

        nodo.rigth = removeMaxRec(nodo.rigth);
        return nodo;
    }

    //public String toString();
    public Iterator<T> iterator(){
        List<T> lista = new ArrayList<>();
        inorder(root, lista);
        return lista.iterator();
    }

    private void inorder(Node nodo, List<T> lista){
        if(nodo == null) return;
        inorder(nodo.left, lista);
        lista.add(nodo.value);
        inorder(nodo.rigth, lista);
    }

    @Override
    public String toString() {
        List<T> lista = new ArrayList<>();
        inorder(root, lista);
        return lista.toString();
    }

    public boolean repOK(){
        if(root == null) return true;

        return inv(root, null, null);
    }

    private boolean inv(Node nodo, T min, T max){
        if(min != null && nodo.value.compareTo(min) <= 0) return false;
        if(max != null && nodo.value.compareTo(max) >= 0) return false;

        return inv(nodo.left, min, nodo.value) && inv(nodo.rigth, nodo.value, max);

    }
}
