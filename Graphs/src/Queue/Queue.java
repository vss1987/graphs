package Queue;
import java.util.LinkedList;

import Graph.Node;

public class Queue {
	LinkedList<Node> queue = new LinkedList<>();
	
	public void add(Node n){
		queue.addLast(n);
	}
	
	public Node get(){
		return queue.removeFirst();
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}

	@Override
	public String toString() {
		return "Queue [queue=" + queue + "]";
	}
	
	
}
