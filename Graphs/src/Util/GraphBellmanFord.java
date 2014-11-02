package Util;

import Graph.Graph;

public class GraphBellmanFord {
	
	public static Graph createGraph(){
		int n = 5;
		String e = "1 2 6,"
				+ "1 5 7,"
				+ "2 3 5,"
				+ "2 4 -4,"
				+ "2 5 8,"
				+ "3 2 -2,"
				+ "4 3 7,"
				+ "4 1 2,"
				+ "5 3 -3,"
				+ "5 4 9";
		Graph g = new Graph(n,e);
		return g;
	}

}
