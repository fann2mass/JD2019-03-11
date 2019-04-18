package by.it.narushevich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        List<Thread> buyers = new ArrayList<>();
        System.out.println("market is opened");

        int time = 0;
        int numberBuyer = 0;
            while (time <= Dispatcher.finishTime) {
                if ((time < 30 || (time > 60 && time < 90)) && Buyer.inMarket <= time + 10) {
                    int count = Util.random(2);
                    for (int n = 0; n < count; n++) {
                        Buyer buyer = new Buyer(++numberBuyer);
                        buyer.start();
                        buyers.add(buyer);
                    }
                }
                if (((time > 30 && time < 60) || (time > 90 && time <= 120)) && Buyer.inMarket <= 40 + (30 - time)) {
                    int count = Util.random(2);
                    for (int n = 0; n < count; n++) {
                        Buyer buyer = new Buyer(++numberBuyer);
                        buyer.start();
                        buyers.add(buyer);
                    }
                }
                time++;
                Util.sleep(1000);
            }

        for (Thread th : buyers) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
        System.out.println("market is closed");
    }
}
