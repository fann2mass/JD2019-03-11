package by.it.vasiliuk.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class TaskC {
    private static StringBuilder currPath;

    public static void main(String[] args) {
        TaskC c =new TaskC();
        Scanner scanner = new Scanner(System.in);
        String firstPath = getFirstPath();
        currPath = new StringBuilder(firstPath);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            if(!s.equals("end"))
                c.process(s);
            else break;
        }
    }
    private static String getFirstPath() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskA.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator;
    }


    private void getFileDescription(File f) {
        String date = new Date(f.lastModified()).toString();
        String desc = f.isDirectory() ? "<DIR>" : ((Long)f.length()).toString();
        Formatter formatter = new Formatter();
        String res = formatter.format("%25s %10s %20s \n", date, desc, f.getName()).toString();
        formatter.close();
        System.out.println(res);


    }

    public void process(String s) {
        switch (s) {
            case "end":
                System.out.println(currPath.toString());
                break;
            case "cd ..":
                String[] split = currPath.toString().split("[\\\\]");
                currPath.delete(0,currPath.length());
                for (int i = 0; i < split.length-1; i++) {
                    currPath.append(split[i]);
                    currPath.append("\\");
                }
                System.out.println(currPath.toString());
                break;
            case "dir":
                File f = new File(currPath.toString());
                String[] list = f.list();
                assert list != null;
                for (String s1 : list) {
                    getFileDescription(new File(currPath + s1));
                }
                System.out.println(currPath);
                break;
            default:
                StringBuilder sb = new StringBuilder(s);
                sb.delete(0,3);
                sb.append("\\");
                currPath.append(sb);
                System.out.println(currPath.toString());
                break;
        }

    }
}
