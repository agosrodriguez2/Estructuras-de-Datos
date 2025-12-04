package grafos.grafosDirigidos;

import grafos.IntGraph;

import java.util.LinkedList;
import java.util.List;

public class AdjacencyListInt implements IntGraph{
    private int V;
    private int E;
    private List<Integer>[] adj;

    public AdjacencyListInt(int v){
        this.V = v;
        this.E = 0;
        this.adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    // Devuelve los vecinos de un vertice
    public List<Integer> adj(int v){
        return adj[v];
    }

    public void addEdge(int v, int w){
        if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }

        if(w < 0 || w >= V){
            throw new IllegalArgumentException();
        }

        E++;
        adj[v].add(w);
    }


    // in-degree -> cantidad de aristas que entran a un nodo.
    // out-degree -> cantidad de aristas que salen del nodo
    public int outDegree(int v){
        return adj[v].size();
    }

    // conexo - fuertemente.
}
