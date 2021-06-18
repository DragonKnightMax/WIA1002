package Lab.L8;

public class Vertex<T extends Comparable<T>, N extends Comparable<N>> {
    T vertexInfo;
    int indeg;
    int outdeg;
    Vertex<T, N> nextVertex;
    Edge<T, N> firstEdge;

    public Vertex() {
        this(null, null);
    }

    public Vertex(T vertexInfo, Vertex<T, N> nextVertex) {
        this.vertexInfo = vertexInfo;
        this.indeg = 0;
        this.outdeg = 0;
        this.nextVertex = nextVertex;
        this.firstEdge = null;
    }
}
