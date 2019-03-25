package by.it.vasiliuk.jd01_01;

public class Main {

    public static void main(String[] args) {
        MyFirstClass myFirstClass=new MyFirstClass();

        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Hello world!!!");
        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Привет мир!");
        myFirstClass.printSlogan();
        Args argObj=new Args(args);
        argObj.printArgs();
    }
}
