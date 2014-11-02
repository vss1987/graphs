package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
	
	Map<Node, List<Node>> graph = new HashMap<>();
	Map<Integer, Node> nodes = new HashMap<>();
	Set<Edge> edges = new HashSet<>();
	
	public Graph(){
		
	}
	
	public Graph(int n, String e){
		for(int i = 1; i<=n; i++){
			addNode(i);
		}
		
		String[] edges = e.split(",");
		for(String edge : edges){
			String[] token = edge.split(" ");
			int from = Integer.parseInt(token[0]);
			int to = Integer.parseInt(token[1]);
			int w = 0;
			
			if(token.length == 3){
				w = Integer.parseInt(token[2]);
			}
			
			addEdge(from, to , w);
		}
	}
	
	public void addNode(Node n){
		if(graph.get(n) == null){
			graph.put(n, new ArrayList<>());
		}else{
			throw new RuntimeException("Node already Exists");
		}
	}
	
	public void addEdge(Node from, Node to, int weight){
		if(graph.get(from) == null || graph.get(to) == null)
			throw new RuntimeException("Either from or to node does not present");
		List<Node> lst = graph.get(from);
		lst.add(to);
		
		edges.add(new Edge(from, to, weight));
	}
	
	public Set<Edge> getEdges(){
		return edges;
	}
	
	public boolean isNodeExists(Node n){
		if(graph.get(n)!=null)
			return true;
		else
			return false;
	}
	
	public List<Node> getAdj(Node n){
		return graph.get(n);
	}
	
	public void addNode(int i){
		Node n = nodes.get(i);
		if(n == null){
			n = new Node(i);
			nodes.put(i, n);
		}
		addNode(n);
	}
	
	public void addEdge(int from, int to){
		Node f = nodes.get(from);
		Node t = nodes.get(to);
		addEdge(f, t, 0);
	}
	
	public void addEdge(int from, int to, int weight){
		Node f = nodes.get(from);
		Node t = nodes.get(to);
		addEdge(f, t, weight);
	}
	
	public Node getNode(int i){
		return nodes.get(i);
	}
	
	public Set<Node> getNodes(){
		return graph.keySet();
	}
	
	public void printPath(int s, int e){
		Node start = getNode(s);
		Node end = getNode(e);
		printPath(start, end);
	}
	
	public void printPath(Node s, Node e){
		
		if(s.equals(e)){
			System.out.println(s);
		}else if(e.getParent() == null){
			System.out.println("no path");
		}else{
			printPath(s, e.getParent());
			System.out.println(e);
		}
	}

	@Override
	public String toString() {
		return "Graph [graph=" + graph + "]";
	}

}
