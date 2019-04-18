package by.it.narushevich.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        System.out.println("market is opened");

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }

        int numberBuyer = 0;
        int counter = 0;
        while (!Dispatcher.planComplete()) {
            int count = Util.random(2);
            for (int n = 0; n < count; n++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer(++numberBuyer);
                    Buyer.pensioneer = numberBuyer % 4 == 0;
                    buyer.start();
                    threads.add(buyer);
                }
                Util.sleep(1000);
            }
        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
        System.out.println("market is closed");
    }
}
