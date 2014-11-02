package ShortestPath;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;

public class BellmanFord {
	public static final int INFINITE = 10000;
	
	public void initSingleSource(Graph g, Node s){
		for(Node n : g.getNodes()){
			n.setDistance(INFINITE);
			n.setParent(null);
		}
		s.setDistance(0);
	}
	
	public void relax(Node from, Node to, int w){
		if(to.getDistance() > from.getDistance() + w){
			to.setDistance(from.getDistance() + w);
			to.setParent(from);
		}
	}
	
	public boolean singleSourceShortestPath(Graph g, Node s){
		initSingleSource(g,s);
		for(int i = 0; i<g.getNodes().size(); i++){
			for(Edge edge : g.getEdges()){
				relax(edge.getFrom(), edge.getTo(), edge.getWeight());
			}
		}
		
		for(Edge edge : g.getEdges()){
			if(edge.getTo().getDistance() > edge.getFrom().getDistance() + edge.getWeight()){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean singleSourceShortestPath(Graph g, int s){
		return singleSourceShortestPath(g, g.getNode(s));
	}
	
	
}
