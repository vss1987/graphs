package MinimumSpanningTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;
import Set.DisjointSet;

public class Kruskal {
	DisjointSet<Node> set = new DisjointSet<>();
	List<Edge> edgeSet = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public List<Edge> mst(Graph g){
		for(Node n : g.getNodes()){
			set.makeSet(n);
		}
		List<Edge> edges = new ArrayList<>();
		edges.addAll(g.getEdges());
		Collections.sort(edges);
		
		for(Edge e : edges){
			if(set.findSet(e.getFrom()) != set.findSet(e.getTo())){
				edgeSet.add(e);
				set.unioin(e.getFrom(), e.getTo());
			}
		}
		
		return edgeSet;
	}
}
