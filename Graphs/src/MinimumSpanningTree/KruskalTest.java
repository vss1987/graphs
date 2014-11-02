package MinimumSpanningTree;

import java.util.List;

import Graph.Edge;
import Graph.Graph;
import Util.GraphKruskal;

public class KruskalTest {
	public static void main(String[] args){
		
		Graph g = GraphKruskal.createGraph();
		
		Kruskal k = new Kruskal();
		List<Edge> set = k.mst(g);
		
		System.out.println(set);
		
	}
}
