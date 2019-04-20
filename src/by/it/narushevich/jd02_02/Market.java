package by.it.narushevich.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {

        List<Thread> buyers = new ArrayList<>();
        List<Thread> cashiers = new ArrayList<>();

        System.out.println("market is opened");

        for (int i = 1; i <=5 ; i++) {
            Cashier cashier = new Cashier(i);
            QueueCashiers.add(cashier);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            cashiers.add(threadCashier);
        }

        int time = 0;
        int numberBuyer = 0;

        while (Dispatcher.planIncomplete()) {
            if (time < 30 && Dispatcher.getBuyerInMarket() <= time + 10) {
                numberBuyer = createBuyer(buyers, numberBuyer);

            } else
            if ((time > 30 && time < 60) && Dispatcher.getBuyerInMarket() <= 40 + (30 - time)) {
                numberBuyer = createBuyer(buyers, numberBuyer);
            }
            else if (time == 60) {
                time = 0;
            }

            time++;
            Util.sleep(1000);
        }

        for (Thread buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        for (Thread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("market is closed");
    }

    private static int createBuyer(List<Thread> buyers, int numberBuyer) {
        int count = Util.random(2);
        if (Dispatcher.planIncomplete()) {
            for (int n = 0; n < count; n++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
                buyers.add(buyer);
            }
        }
        return numberBuyer;
    }
}
