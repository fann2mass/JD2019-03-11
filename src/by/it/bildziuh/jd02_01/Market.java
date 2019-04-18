package by.it.bildziuh.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {

        List<Thread> buyers = new ArrayList<>();
        System.out.println("market is opened");

        int time = 0;
        int numberBuyer = 0;
        for (int cycles = 0; cycles < 2; cycles++) {
            while (time < Dispatcher.fullCycle) {

                int count = Util.random(2);
                for (int n = 0; n < count; n++) {
                    Buyer buyer = new Buyer(++numberBuyer);
                    buyer.start();
                    buyers.add(buyer);
                }
                if (time > 30 && Dispatcher.buyerInMarket <= 40 + (30 - time))
                    continue;

                if (time <= 30 && Dispatcher.buyerInMarket <= time + 10)
                    continue;

                Util.sleep(1000);
                time++;

            }
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
