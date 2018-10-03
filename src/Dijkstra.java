import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
    public List<Vertex> getPath(Vertex startVertex, Vertex targetVertex) {
    	//Set the starting vertex minimum distance to 0
        startVertex.setMinCost(0);
        //Create a new heap
        Heap myHeap = new Heap(200000);
        //Add the starting vertex to the head of the heap
        myHeap.enque(startVertex);
        while (!myHeap.isEmpty()) {
        	//Grab the vertex at the head of the heap
        	Vertex currentV = myHeap.deque();
            //Cycle through the edges from this vertex
            for (Edge edge : currentV.getEdges()) {
                Vertex targetV = edge.getTargetVertex();
                int cost = edge.getCost();
                int minCost = currentV.getMinCost() + cost;
                //If the minimum cost to a vertex connected to this one by an edge is shorter when
                //coming from this vertex, switch the previous vertex to this one
                //and change the min cost
                if (minCost < targetV.getMinCost()) {
                    targetV.setPreviosVertex(currentV);
                    targetV.setMinCost(minCost);
                    myHeap.enque(targetV);                  
                }
            }
            //If the current vertex is the target, return path
            //to this vertex
            if(currentV.equals(targetVertex)) {
            	return assemblePath(currentV);
            }
        }
        //If the target vertex was not found, there is no path to it
        return null;
    }
    //Get the shortest path by traveling from target vertex back to start
    private List<Vertex> assemblePath(Vertex targetVertex) {
        List<Vertex> path = new ArrayList<>();
        //Collect each vertex from the target to the start
        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPreviosVertex()) {
            path.add(vertex);
        }
        //Reverse the path before returning it
        Collections.reverse(path);
        return path;
    }
}