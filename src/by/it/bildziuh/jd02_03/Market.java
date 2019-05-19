package by.it.bildziuh.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    public static void main(String[] args) {

        System.out.println("market is opened");

        ExecutorService executorService = Executors.newFixedThreadPool(Dispatcher.cashierMax);
        for (int i = 1; i <= Dispatcher.cashierMax; i++) {
            Cashier cashier = new Cashier(i);
            executorService.execute(cashier);
        }

        int time = 0;
        int numberBuyer = 0;
        while (!Dispatcher.planComplete()) {
            if (time >= 60) time -= 60;
            int count = Util.random(2);
            for (int n = 0; n < count; n++) {
                if (!Dispatcher.planComplete()) {
                    Buyer buyer = new Buyer(++numberBuyer);
                    buyer.start();
                }
            }

            if (time > 30 && Dispatcher.buyerInMarket.get() <= 40 + (30 - time)) {
                Util.sleep(10);
                continue;
            }
            if (time <= 30 && Dispatcher.buyerInMarket.get() <= time + 10) {
                Util.sleep(10);
                continue;
            }
            Util.sleep(1000);
            time++;
        }

        executorService.shutdown();

        while (!executorService.isTerminated())
            Util.sleep(1000);

        System.out.println("======================market is closed========================");

    }
}
