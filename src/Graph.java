import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
    private List<Vertex> vertexes;

    public Graph() {
    	this. vertexes = new ArrayList<Vertex>();
    }
    public Vertex getVertex(Vertex vertexToFind) {
    	return vertexes.get(vertexes.indexOf(vertexToFind));
    }
    //Reset all of the values for each vertex to their starting value
    public void resetValues() {
    	for(Vertex vertex:vertexes) {
    		vertex.setMinCost(Integer.MAX_VALUE);
    		vertex.setPreviosVertex(null);
    		vertex.setVisited(false);
    		}
    }
    //Given a file scanner, construct a list of vertexes with their corresponding edges
    public void buildGraphFromFile(Scanner fileIn) {
		
		String departFrom;
		String arriveTo;
		int cost;	
		while(fileIn.hasNextLine())
		{
			departFrom = fileIn.next();
			arriveTo = fileIn.next();
			cost =  fileIn.nextInt();            
			
			Vertex sourceLoc = new Vertex(departFrom);
			if(!vertexes.contains(sourceLoc)) {
				vertexes.add(sourceLoc);
			}
			Vertex destLoc = new Vertex(arriveTo);
			if(!vertexes.contains(destLoc)) {
				vertexes.add(destLoc);
			}
			getVertex(sourceLoc).addEdge(new Edge(getVertex(sourceLoc), getVertex(destLoc), cost));
		}       
        
	}
}