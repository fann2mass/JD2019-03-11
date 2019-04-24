package by.it.narushevich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Market {

    public static void main(String[] args) {

        System.out.println("market is opened");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            executorService.execute(cashier);
        }

        int time = 0;
        int numberBuyer = 0;

        while (Dispatcher.planInComplete()) {
            if (time < 30 && Dispatcher.getBuyerInMarket() <= time + 10)
                numberBuyer = getNumberBuyer(numberBuyer);
            else if ((time > 30 && time < 60) && Dispatcher.getBuyerInMarket() <= 40 + (30 - time))
                numberBuyer = getNumberBuyer(numberBuyer);
            else if (time == 60) time = 0;

            time++;
            Util.sleep(1000);
        }

        executorService.shutdown();

        while (!executorService.isTerminated())
            Util.sleep(10);
        System.out.println("market is closed");
    }

    private static int getNumberBuyer(int numberBuyer) {
        int count = Util.random(2);
        if (Dispatcher.planInComplete()) {
            for (int n = 0; n < count; n++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
            }
        }
        return numberBuyer;
    }
}
