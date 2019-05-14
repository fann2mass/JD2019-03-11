package by.it.narushevich.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Singleton logger = Singleton.getInstance();
        for (int i = 0; i < 2; i++) {
            logger.log("Message "+i);
        }
    }
}
