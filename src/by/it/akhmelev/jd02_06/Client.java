package by.it.akhmelev.jd02_06;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Singleton logger=Singleton.getInstance();
        for (int i = 0; i < 10; i++) {
            logger.log("Message "+i);
            Thread.sleep(800);
        }
    }
}
