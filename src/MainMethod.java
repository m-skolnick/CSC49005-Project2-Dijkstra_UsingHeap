import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainMethod {

	//private List<Vertex> nodes;
    private List<Edge> edges;
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter the name of an input file: ->");
		
		//String filePath = kbd.next();
		String filePath = "C:\\Users\\Inspiron\\Source\\Repos\\eclipse-workspace\\CSC49005-Project2-Dijkstra_UsingHeap\\src\\example.txt";
				
		Scanner fileIn = new Scanner(new File(filePath));
		
		Graph myGraph = new Graph();
		myGraph.buildGraphFromFile(fileIn);
		
		String startLocString = "";
		String endLocString;		
		do {
			System.out.print("Pease enter a source and a destination (q to quit): ");
			startLocString = kbd.next();
			if(startLocString =="q") {
				return;
			}
			endLocString = kbd.next();
			
			myGraph.resetValues();
			
			Vertex startLoc = new Vertex(startLocString);
			startLoc = myGraph.getVertex(startLoc);
			Vertex endLoc = new Vertex(endLocString);
			endLoc = myGraph.getVertex(endLoc);
			
	        Dijkstra dijkstra = new Dijkstra();
	        List path = dijkstra.getPath(startLoc,endLoc);
	        System.out.print("Cheapest trip from "+startLoc+" -> "+endLoc+":"+endLoc.getMinCost()+" ");
	        System.out.println(path);
		}
		while(startLocString != "q");
	}
}
