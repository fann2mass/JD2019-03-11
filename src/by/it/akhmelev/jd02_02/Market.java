package by.it.akhmelev.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        System.out.println("market is opened");

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            threads.add(threadCashier);
        }

        int numberBuyer = 0;
        while (!Dispatcher.planComplete()) {
            int count = Util.random(2);
            for (int n = 0; n < count; n++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer(++numberBuyer);
                    buyer.start();
                    threads.add(buyer);
                }
            }
            Util.sleep(1000);
        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                System.out.println("wow");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("=================market is closed");

    }
}
