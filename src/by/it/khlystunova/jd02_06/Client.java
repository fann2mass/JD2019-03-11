package by.it.khlystunova.jd02_06;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Singleton singleton = Singleton.getInstance();
        for (int i = 0; i < 10; i++) {
           singleton.log("message "+ i);
           Thread.sleep(800);
        }
    }
}
