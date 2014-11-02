package NaiveBayse;

import java.util.ArrayList;
import java.util.List;

public class Util {
	
	public static Number sum(List<? extends Number> lst){
		Double res =  0.0;
		for(Number i : lst){
			res = res + i.doubleValue();
		}
		return res;
	}

	
	public static List<Integer> add(List<Integer> lst1, List<Integer> lst2){
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i<lst1.size(); i++){
			res.add(lst1.get(i) + lst2.get(i));
		}
		return res;
	}
	
	public static List<Double> divide(List<Integer> lst, Integer denom){
		List<Double> res = new ArrayList<>();
		for(Integer i : lst){
			res.add((double) i/denom);
		}
		return res;
	}
	
	public static List<Number> multiply(List<? extends Number> lst1, List<? extends Number> lst2){
		List<Number> res = new ArrayList<>();
		for(int i = 0; i<lst1.size(); i++){
			res.add( lst1.get(i).doubleValue() * lst2.get(i).doubleValue());
		}
		return res;
	}


}
