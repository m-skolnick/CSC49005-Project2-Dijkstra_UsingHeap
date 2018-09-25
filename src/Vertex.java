import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private String name;
    private List<Edge> edges;
    private boolean visited;
    private Vertex previousVertex;
    private int minDistance = Integer.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        this.edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
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

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.minDistance, otherVertex.minDistance);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}