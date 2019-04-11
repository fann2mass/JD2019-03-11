package by.it.eslaikouskaya.jd01_12;

import java.util.*;

public class TaskC1 {
	public static void main(String[] args) {
		Map<String, Integer> removed = new HashMap<>();
		List<String> names = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		String str;
		while ((!(str=scanner.nextLine()).equals("end"))){
			names.add(str);
		}
		for (int i = 0; i < names.size(); i++) {
			removed.put(names.get(i), i + 1);
		}

		System.out.println(names);
		for (Map.Entry<String, Integer> entry : removed.entrySet()){
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}