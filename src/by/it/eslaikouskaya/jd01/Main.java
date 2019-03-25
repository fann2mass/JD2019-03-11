package by.it.eslaikouskaya.jd01;

public class Main {

    public static void main(String[] args) {
        Hello hello= new Hello();
        hello.printSlogan();
        hello.setSlogan("Привет мир!");
        hello.printSlogan();
        Args argObj=new Args(args);
        argObj.printArgs();
    }
}
