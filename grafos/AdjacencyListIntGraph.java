import java.util.LinkedList;
import java.util.List;

public class AdjacencyListIntGraph implements IntGraph {
    // Number of vertices in the graph.
    private final int V;
    //Number of edges int the graph.
    private int E;
    //Adajacency lists.
    private List<Integer>[] adj;

    private DepthFirstSearch dfs;
 
    
    public AdjacencyListIntGraph(int V){
        if (V < 0){
            throw new IllegalArgumentException("Number of vertices must be non-negativa");
        }

        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<Integer>();
        }   
        dfs = new DepthFirstSearch(this, 0); 
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
        adj[w].add(v);
    }

    public List<Integer> adj(int v){
        if(v < 0 || v >= V){
            throw new IllegalArgumentException();
        }
        return adj[v];
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    // El grado de un vertice: es decir, cuantas aristas salen de el.
    public int degree(int v){
        return adj[v].size();
    }

    // cuatas vertices se conectan consigo mismo.
    public int numberOfSelfLoops(){
        int count = 0;
        for(int v = 0; v < V; v++){
            for(int w : adj[v]){
                if(v == w){
                    count++;
                }
            }
        }
        return count/2;
    }

    public String toString(){
        String s = V + " vertices, " + E + " edges\n";
        for(int v = 0; v < V; v++){
            s += v + ": ";
            for(int w : adj[v]){
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    public boolean esConexo(){
        return dfs.count() == V;
    }
}
