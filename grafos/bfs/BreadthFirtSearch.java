import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirtSearch {
    private boolean marked[];
    private int[] edgeTo;

    public void bfs(AdjacencyListIntGraph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        Queue<Integer> q = new LinkedList<Integer>();
        marked[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int v = q.poll();
            for(int w : G.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    q.add(w);
                }
            }
        }
    }

    // Construir camino dado un S(origen).
}
