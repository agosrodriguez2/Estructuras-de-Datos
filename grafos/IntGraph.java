package grafos;
import java.util.List;

public interface IntGraph{
    
    /**
     * @post returns the number of vertices in this graph.
     */
    public int V();

    /**
     * @post Returns the number of edges in this graph.
     */
    public int E();

    /**
     * @pre 0 <= v < V && 0 <= w < V
     * @post Add the undirected edge v-w to this graph.
     */
    public void addEdge(int v, int w);

    /**
     * @pre 0 <= v < V
     * @post Returns the list of vertices adjacent to vertex v.
    */
    public List<Integer> adj(int v);
    
}