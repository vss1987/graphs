package Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class DisjointSet<E> {
	
	Map<E, Integer> map = new HashMap<>();
	
	public void makeSet(E i){
		map.put(i, map.size()+1);
	}
	
	public void unioin(E u, E v){
		Integer target = map.get(u);
		Integer curr = map.get(v);
		for(E key : map.keySet()){
			if(map.get(key) == curr){
				map.put(key, target);
			}
		}
	}
	
	public Integer findSet(E u){
		return map.get(u);
	}

	@Override
	public String toString() {
		return "DisjointSet [map=" + map + "]";
	}
	
	

}
