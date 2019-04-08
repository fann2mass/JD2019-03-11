package by.it.eslaikouskaya.jd01_12;

import java.util.*;
public class TaskB2 {
	public static void main(String[] args) {
		List<String> peoples = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите кол-во человек");
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			peoples.add("name" +(i+1));
		}
		ArrayList<String> people1 = new ArrayList<>(peoples);
		LinkedList<String> people2 = new LinkedList<>(peoples);
		String res1 = process(people1);
		String res2 = process(people2);
		System.out.println("Последний эл-т ArrayList: " + res1 + "\nПоследний эл-т LinkedList: " + res2);
	}

	private static String process(ArrayList<String> people1) {
		int pos = 0;
		while (people1.size() != 1) {
			pos = (pos + 1) % people1.size();
			people1.remove(pos);
		}
		return people1.get(0);
	}

	private static String process(LinkedList<String> people2) {
		int pos = 0;
		for (int i = 0; i < people2.size(); i++) {
			pos = (pos + 2) % (i + 1);
		}
		if (pos==0) return people2.get(0);

		ListIterator<String> listIt = people2.listIterator();
		while (listIt.hasNext()) {
			if (listIt.next().endsWith(String.valueOf(pos)))
					return listIt.next();
			}
		return listIt.next();
	}


}

