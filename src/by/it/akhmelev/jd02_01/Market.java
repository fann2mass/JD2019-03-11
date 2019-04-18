package by.it.akhmelev.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {

        List<Thread> buyers = new ArrayList<>();
        System.out.println("market is opened");

        int time = 0;
        int numberBuyer = 0;
        while (time < Dispatcher.finishTime) {
            int count = Util.random(2);
            for (int n = 0; n < count; n++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
                buyers.add(buyer);
            }
            time++;
            Util.sleep(1000);
        }

        for (Thread th : buyers) {
            try {
                th.join();
            } catch (InterruptedException e) {
                System.out.println("wow");
            }
        }
        System.out.println("=================market is closed");

    }
}
