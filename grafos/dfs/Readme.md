DFS (Depth-First search)

- Recorre un grafo lo mas profundo posible, antes de retroceder (backtracking) y tomar otros caminos.

- Tenemos que llevar un registro de los vertices visitados para evitar bucles infinitos.

Como funciona ?

1. Marca un vertice como visitado.
2. Visita recursivamente todos los vecinos no visitados.
3. Vuelve atras cuando ya no quedan vecinos por explorar.

Un grafo no dirigido es conexo si desde cualquier vertice poder llegar a cualqueir otro vertice, es decir, existe un camino entre todos los pares de vertices.

En otras palabras, si haces un DFS desde un unico vertice, debes poder visitar todos los vertices del grafo.

entonces, si count == G.V() -> el grafo es conexo.
