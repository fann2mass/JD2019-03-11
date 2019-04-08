package by.it.eslaikouskaya.jd01_12;

import java.util.*;

public class TaskA2 {
	public static void main(String[] args) {

		List<Integer>listA= Arrays.asList(1,2,4,5,6,7,8,9,0,3,3,2,5,4,3);
		List<Integer>listB= Arrays.asList(1,6,4,5,7,7,8,9,9,14,16,18);
		HashSet<Integer>a=new HashSet<>(listA);
		TreeSet<Integer>b=new TreeSet<>(listB);
		System.out.println("HashSet: "+a+"\nTreeSet: "+b);

		System.out.println("Cross: "+getCross(a,b));
		System.out.println("Union: "+getUnion(a,b));
	}


	private static Set<Integer> getUnion(Set<Integer> a, Set<Integer>b){
		Set<Integer> result = new HashSet<>(a);
		result.addAll(b);
		return result;
	}

	private static Set<Integer> getCross(Set<Integer> a, Set<Integer>b){
		Set<Integer> result = new HashSet<>(a);
		result.retainAll(b);
		return result;
	}
}
