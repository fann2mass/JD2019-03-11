package by.it.bolotko.jd02_06.Task_A;

public class Client {
    public static void main(String[] args) {
        Singleton logger = Singleton.getInstance();
        for (int i = 1; i <= 100; i++) {
            logger.log("\tGood day to you!!!" + i + " times  :)");
        }
    }
}
