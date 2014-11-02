package Util;

import Graph.Graph;

public class Graph1 {
	public static Graph createGraph(){
		Graph g = new Graph();
		for(int i = 1; i<=5; i++){
			g.addNode(i);
		}
		g.addEdge(1, 2);
		g.addEdge(1, 5);
		g.addEdge(2, 1);
		g.addEdge(2, 5);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 2);
		g.addEdge(3, 4);
		g.addEdge(4, 2);
		g.addEdge(4, 5);
		g.addEdge(4, 3);
		g.addEdge(5, 4);
		g.addEdge(5, 1);
		g.addEdge(5, 2);
		
		return g;
	}
}
