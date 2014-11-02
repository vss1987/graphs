package Util;

import Graph.Graph;

public class GraphKruskal {
	public static Graph createGraph(){
		
		Graph g = new Graph();
		for(int i = 1; i<=9; i++){
			g.addNode(i);
		}
		g.addEdge(1, 2, 4);
		g.addEdge(1, 8, 8);
		
		g.addEdge(2, 1, 4);
		g.addEdge(2, 3, 8);
		g.addEdge(2, 8, 11);
		
		g.addEdge(3, 2, 8);
		g.addEdge(3, 9, 2);
		g.addEdge(3, 6, 4);
		g.addEdge(3, 4, 7);
		
		g.addEdge(4, 3, 7);
		g.addEdge(4, 5, 9);
		g.addEdge(4, 6, 14);
		
		g.addEdge(5, 4, 9);
		g.addEdge(5, 6, 10);
		
		g.addEdge(6, 4, 14);
		g.addEdge(6, 5, 10);
		g.addEdge(6, 3, 4);
		g.addEdge(6, 7, 2);
		
		g.addEdge(7, 6, 2);
		g.addEdge(7, 9, 6);
		g.addEdge(7, 8, 1);
		
		g.addEdge(8, 7, 1);
		g.addEdge(8, 9, 7);
		g.addEdge(8, 2, 11);
		g.addEdge(8, 1, 8);
		
		g.addEdge(9, 3, 2);
		g.addEdge(9, 8, 7);
		g.addEdge(9, 7, 6);
		
		return g;
	}
	
}
