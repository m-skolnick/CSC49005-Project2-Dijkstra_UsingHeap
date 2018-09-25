import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
    private List<Vertex> vertexes;

    public Graph() {
    	this. vertexes = new ArrayList<Vertex>();
    }
    public List<Vertex> getVertexes() {
        return vertexes;
    } 
    public Vertex getVertex(Vertex vertexToFind) {
    	return vertexes.get(vertexes.indexOf(vertexToFind));
    }
    public void resetValues() {
    	for(Vertex vertex:vertexes) {
    		vertex.setMinDistance(Integer.MAX_VALUE);
    		vertex.setPreviosVertex(null);
    		vertex.setVisited(false);
    		}
    }
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
			getVertex(sourceLoc).addNeighbour(new Edge(getVertex(sourceLoc), getVertex(destLoc), cost));
		}       
        
	}
    @Override
    public Graph clone() throws CloneNotSupportedException {
        return (Graph)super.clone();
    }
}