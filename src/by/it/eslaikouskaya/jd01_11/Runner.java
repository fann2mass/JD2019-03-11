package by.it.eslaikouskaya.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
	public static void main(String[] args) {
		 List<String> myList = new ListB<>();
		 List<String> arList = new ArrayList<>();
		 List<String> myList2 = new ArrayList<>();
//1
		 myList.add("One"); arList.add("One");  myList2.add("One");
		 myList.add("Two"); arList.add("Two"); myList2.add("Two");
		 myList.add("Four"); arList.add("Four"); myList2.add("Four");
		System.out.println("1\nmyList: "+myList+"\narList: "+arList);
//2
		myList.add(2,"Tree"); arList.add(2,"Tree");
		myList.add(0,"Start"); arList.add(0,"Start");
		System.out.println("2\nmyList: "+myList+"\narList: "+arList);
//3
		myList.remove("Start"); arList.remove("Start");
		myList.remove(3); arList.remove(3);
		System.out.println("3\nmyList: "+myList+"\narList: "+arList);
//4
		System.out.println("4\nmyList(0): "+myList.get(0)+"\narList(0): "+arList.get(0));
//5
		System.out.println("5\nmyList: "+myList.set(2,"Double tree")+"\narList: "+
				arList.set(2,"Double tree"));
//6
		myList.addAll(myList2); arList.addAll(myList2);
		System.out.println("6\nmyList: "+myList+"\narList: "+
				arList);
//7
		System.out.println("7\nmyList: "+myList.size()+"\narList: "+
				arList.size());
//8
		System.out.println("8\nmyList: "+myList.isEmpty()+"\narList: "+
				arList.isEmpty());
//9
		System.out.println("9\nmyList: "+myList.contains("Tree")+"\narList: "+
				arList.contains("Tree"));
//10
		System.out.println("10\nmyList: "+myList.containsAll(myList2)+
				"\narList: "+arList.containsAll(myList2));
//11
		System.out.println("11\nmyList: "+myList.removeAll(myList2)+
				"\narList: "+arList.removeAll(myList2));
	}
}
