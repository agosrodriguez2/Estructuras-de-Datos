package grafos.grafosDirigidos.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import grafos.grafosDirigidos.AdjacencyListInt;

public class BfsIntGraph{
    private boolean[] marked;
    private int[] edgeTo;

    public void bfs(AdjacencyListInt G, int s){
        marked = new boolean[G.V()];
        Queue<Integer> cola = new LinkedList<>();
        // primer vertice visitado
        marked[s] = true;
        cola.add(s);
        while (!cola.isEmpty()) {
            int v = cola.poll();
            // recorre los vecinos del vertice v.
            for(int w : G.adj(v)){
                if(!marked[w]){
                    marked[w]= true;
                    cola.add(w);
                }
            }
        }
    }

    public void bfsPath(AdjacencyListInt G, int s){
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];

        Queue<Integer> cola = new LinkedList<>();
        marked[s] = true;
        // edgeTo[origen] = origen.
        edgeTo[s] = s;
        cola.add(s);
        while (!cola.isEmpty()) {
            int v = cola.poll();
            for(int w : G.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    cola.add(w);
                }
            }
        }
    }

    public List<Integer> pathTo(int d){
        if(!marked[d]) return null;
        Stack<Integer> path = new Stack<>();
        for(int i = d; i != edgeTo[i]; i = edgeTo[i]){
            path.push(i);
        }
        path.push(d);
        return path;
    }

    public List<Integer> pathTo2(int origen, int d){
        if(!marked[d]) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = d; x != origen; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(origen);

        return path;
    }
   
}