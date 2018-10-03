/*
 * Created by Micaiah Skolnick for Class: Algorithm design and analysis
 * At: Lindenwood University
 * Professor: Dr. Stephen Blythe
 * Date: 09/26/18
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MainMethod {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter the name of an input file: -> ");
		//Get the file path	
		String filePath = kbd.next();
				
		Scanner fileIn = new Scanner(new File(filePath));
		//Create a new graph
		Graph myGraph = new Graph();
		//Read in the file information to the graph
		myGraph.buildGraphFromFile(fileIn);
		
		String startLocString,endLocString;		
		do {
			System.out.print("Pease enter a source and a destination (q to quit): ");
			startLocString = kbd.next();
			if(startLocString =="q") {
				return;
			}
			endLocString = kbd.next();
			myGraph.resetValues();
			Vertex startLoc = new Vertex(startLocString);
			Vertex endLoc = new Vertex(endLocString);
			
			startLoc = myGraph.getVertex(startLoc);
			endLoc = myGraph.getVertex(endLoc);
			
	        Dijkstra dijkstra = new Dijkstra();
	        List path = dijkstra.getPath(startLoc,endLoc);
	        System.out.print("Cheapest trip from "+startLoc+" -> "+endLoc+":"+endLoc.getMinCost()+" ");
	        System.out.println(path);
		}
		while(startLocString != "q");
	}
}
