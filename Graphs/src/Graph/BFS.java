package Graph;
import Queue.Queue;


public class BFS {
	
	Queue queue = new Queue();
	
	public void search(Graph g, Node s){
		s.setColor(1);
		s.setDistance(0);
		s.setParent(null);
		queue.add(s);
		while(!queue.isEmpty()){
			Node u = queue.get();
			for(Node n : g.getAdj(u)){
				if(n.getColor() == 0){
					n.setColor(1);
					n.setDistance(u.getDistance() + 1);
					n.setParent(u);
					queue.add(n);
				}
			}
			u.setColor(2);
		}
		
	}
	
	public void search(Graph g, int i){
		Node n = g.getNode(i);
		search(g,n);
	}
	
	public void printPath(Graph g, Node s, Node e){
		
		if(s.equals(e)){
			System.out.println(s);
		}else if(e.getParent() == null){
			System.out.println("no path");
		}else{
			printPath(g, s, e.getParent());
			System.out.println(e);
		}
	}
	
	public void printPath(Graph g , int s, int e){
		Node start = g.getNode(s);
		Node end = g.getNode(e);
		printPath(g, start, end);
	}
}
