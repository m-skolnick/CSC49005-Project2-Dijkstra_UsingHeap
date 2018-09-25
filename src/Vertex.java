import java.util.ArrayList;
import java.util.List;
//Implements comparable for later use in priority queue
public class Vertex implements Comparable<Vertex> {
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
    public void setMinCost(int minDistance) {
        this.minCost = minDistance;
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
    //Use compareTo for priority queue
    @Override
    public int compareTo(Vertex otherVertex) {
        return Integer.compare(this.minCost, otherVertex.getMinCost());
    }
    //Use .equals for seeing when two vertexes are of equal value
    @Override
    public boolean equals(Object obj) {
        Vertex comparingTo = (Vertex) obj;
        if (name.equals(comparingTo.name)) {
            return true;
        }
        return false;
    }
}