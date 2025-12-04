/**
 * Realiza una busqueda en profundidad (DFS) desde un vertice origen S.
 * Marca todos los vertices que son alcanzables desde S.
 * Cuenta cuantos vertoces pudo alcanzar.
 * Guarda el camino que tomo para llegar a cada vertice.
 */

import java.util.Stack;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    private int[] edgeTo; // edgeTo[w] = v significa que llegamos a w desde v.
    private final int s;

    public DepthFirstSearch(AdjacencyListIntGraph G, int s){
        // Arreglo que guarda los visitados, tamaño cantidad de vertices del grafo original.
        marked = new boolean[G.V()];
        //numero de vertices alcanzados desde el vertice fuente S.
        this.count = 0;
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(AdjacencyListIntGraph G, int v){
        count++;
        marked[v] = true;
        // No se vuelve a recorrer para nodos marcados.
        for(int w : G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v; // para llegar a w venimos desde v.
                dfs(G, w);
            }
        }
    }

    // Indica por cuantos vertices esta conectado un vertice n.
    public int count(){
        return count;
    }

    // existe el camino de s a v ?
    /**
     * indica si existe un camino desde el vertice origen s hasta el vertice v.
     */
    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();
        for(int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

}
