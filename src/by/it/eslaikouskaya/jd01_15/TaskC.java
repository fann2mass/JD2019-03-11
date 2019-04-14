package by.it.eslaikouskaya.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {

	private static StringBuilder directory = new StringBuilder();

	private static String getFileName(Class<?> cl) {
		String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
		String strPackage = cl.getPackage().getName().replace(".", File.separator);
		return src+strPackage;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String filename = getFileName(TaskB.class);
		System.out.println(filename);
		directory.append(filename);
		for (; ; ) {
			StringBuilder command = new StringBuilder(scan.nextLine());
			if (command.toString().equals("end")) break;
			whatToDo(command);
		}
	}

	private static void whatToDo(StringBuilder command) {
		if (command.toString().equals("cd ..")||command.toString().equals("cd..")) {
			directory.delete(directory.lastIndexOf(File.separator), directory.length());
		}
		if (command.toString().contains("cd ")){
			command.delete(0,3);
			directory.append(File.separator).append(command);
		}
		if (command.toString().equals("dir")) {
			try {
				File file = new File(directory.toString());
				String[] dir = file.list();
				StringBuilder resentDir = new StringBuilder(directory);
				System.out.println("     "+resentDir.delete(resentDir.lastIndexOf(File.separator),
						resentDir.length()).delete(0, resentDir.lastIndexOf(File.separator) + 1));
				for (String s : dir) {
					System.out.println(s);
				}
				System.out.println();
			} catch (NullPointerException e){
				System.out.println("Error: empty");
			}
		}

	}


}
