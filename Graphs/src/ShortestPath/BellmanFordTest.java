package ShortestPath;

import Graph.Graph;
import Util.GraphBellmanFord;

public class BellmanFordTest {
	public static void main(String[] args){
		BellmanFord bf = new BellmanFord();
		
		Graph g = GraphBellmanFord.createGraph();
		
		boolean res = bf.singleSourceShortestPath(g, 1);
		
		if(!res){
			System.out.println("Negative weighted cycle present. No path possible");
		}
		
		System.out.println(g);
		
		g.printPath(1, 2);
		
	}
}
