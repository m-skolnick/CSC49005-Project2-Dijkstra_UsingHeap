import java.util.ArrayList;
import java.util.List;
public class Vertex {
    private String name;
    private List<Edge> edges;
    private int minCost = Integer.MAX_VALUE;
    private boolean visited;
    private Vertex previousVertex;
    
    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }
    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }
    public List<Edge> getEdges() {
        return edges;
    }
    public int getMinCost() {
        return minCost;
    }
    public void setMinCost(int minCost) {
        this.minCost = minCost;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public Vertex getPreviosVertex() {
        return previousVertex;
    }
    public void setPreviosVertex(Vertex previosVertex) {
        this.previousVertex = previosVertex;
    }
    @Override
    public String toString() {
        return name;
    }
    //If two vertexes have the same name, we want to say they are the same
    @Override
    public boolean equals(Object obj) {
        Vertex comparingTo = (Vertex) obj;
        if (name.equals(comparingTo.name)) {
            return true;
        }
        return false;
    }
}