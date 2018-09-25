public class Edge {
    private int cost;
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(Vertex startVertex, Vertex targetVertex, int cost) {
        this.cost = cost;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public Vertex getStartVertex() {
        return startVertex;
    }
    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }
    public Vertex getTargetVertex() {
        return targetVertex;
    }
    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}