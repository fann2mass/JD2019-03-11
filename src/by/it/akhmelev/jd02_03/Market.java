package by.it.akhmelev.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Market {

    public static void main(String[] args) {

        System.out.println("market is opened");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            executorService.execute(cashier);
        }

        int numberBuyer = 0;
        while (!Dispatcher.planComplete()) {
            int count = Util.random(2);
            for (int n = 0; n < count; n++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer(++numberBuyer);
                    buyer.start();
                }
            }
            Util.sleep(1000);
        }

        executorService.shutdown();
        while (!executorService.isTerminated())
            Util.sleep(1);
        System.out.println("=================market is closed");

    }
}
