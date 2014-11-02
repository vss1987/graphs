package Graph;

import Util.Graph1;


public class GraphTest {
	
	
	
	public void displayGraph(Graph g){
		System.out.println(g.toString());
	}
	
	public static void main(String[] args){
		GraphTest gt = new GraphTest();
		Graph g = Graph1.createGraph();
		//gt.displayGraph(g);
		BFS bfs = new BFS();
		bfs.search(g, 1);
		bfs.printPath(g, 1, 4);
		
		DFS dfs = new DFS();
		//dfs.search(g);
		
		
		//System.out.println(g);
		//gt.displayGraph(g);
	}
	
}
