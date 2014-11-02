package Graph;


public class DFS {
	public static int time = 0;
	public void search(Graph g){
		for(Node node : g.getNodes()){
			if(node.getColor() == 0){
				dfsVisit(g,node);
			}
		}
	}
	
	
	public void dfsVisit(Graph g, Node u){
		time = time + 1;
		u.setStartTime(time);
		u.setColor(1);
		for(Node node : g.getAdj(u)){
			if(node.getColor() == 0){
				node.setParent(u);
				dfsVisit(g,node);
			}
		}
		u.setColor(2);
		time = time + 1;
		u.setfTime(time);
	}
}
