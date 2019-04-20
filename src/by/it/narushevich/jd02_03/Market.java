package by.it.narushevich.jd02_03;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        System.out.println("market is opened");

        File buyers = new File(Buyer.getPath());
        buyers.delete();

        for (int i = 1; i <=5 ; i++) {
            Cashier cashier = new Cashier(i);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            threads.add(threadCashier);
        }

        int time = 0;
        int numberBuyer = 0;

        while (!Dispatcher.planComplete()) {
            if (time < 30 && Dispatcher.getBuyerInMarket() <= time + 10) {
                int count = Util.random(2);
                if (!Dispatcher.planComplete()) {
                    for (int n = 0; n < count; n++) {
                        Buyer buyer = new Buyer(++numberBuyer);
                        buyer.start();
                        threads.add(buyer);
                    }
                }
            } else
            if ((time > 30 && time < 60) && Dispatcher.getBuyerInMarket() <= 40 + (30 - time)) {
                int count = Util.random(2);
                if (!Dispatcher.planComplete()) {
                    for (int n = 0; n < count; n++) {
                        Buyer buyer = new Buyer(++numberBuyer);
                        buyer.start();
                        threads.add(buyer);
                    }
                }
            }

            if (time == 60) {
                time = 0;
            }

            time++;
            Util.sleep(1000);
        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("market is closed");
    }


}
