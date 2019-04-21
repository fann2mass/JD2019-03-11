package by.it.bildziuh.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        System.out.println("market is opened");

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            threads.add(threadCashier);
        }
        int time = 0;
        int numberBuyer = 0;
        while (!Dispatcher.planComplete()) {
            if (time >= 60)
                time -= 60;
/*            if (QueueBuyers.size() / activeCashier < 5) {
                try {
                    threads.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                activeCashier--;
            }
            if (QueueBuyers.size() / activeCashier > 5) {
                threads.notify();
                activeCashier++;
            }*/

            int count = Util.random(2);
            for (int n = 0; n < count; n++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer(++numberBuyer);
                    buyer.start();
                    threads.add(buyer);
                }
            }

            if (time > 30 && Dispatcher.buyerInMarket <= 30 + (30 - time))
                continue;
            if (time <= 30 && Dispatcher.buyerInMarket <= time + 5)
                continue;
            Util.sleep(1000);
            time++;
        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                System.out.println("wow");
            }
        }
        System.out.println("=================market is closed");

    }
}
