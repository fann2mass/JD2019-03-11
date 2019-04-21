package by.it.bildziuh.jd02_02;

public class Market {

    public static void main(String[] args) {

        System.out.println("market is opened");

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            Buyer.buyers.add(threadCashier);
            Util.activeCashier++;
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
                    Buyer.buyers.add(buyer);
                }
            }

            if (time > 30 && Dispatcher.buyerInMarket <= 30 + (30 - time)) {
                Util.sleep(1);
                continue;
            }
            if (time <= 30 && Dispatcher.buyerInMarket <= time + 10) {
                Util.sleep(1);
                continue;
            }
            Util.sleep(1000);
            time++;
        }

        for (Thread buyer : Buyer.buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("wow");
            }
        }
        System.out.println("=================market is closed");

    }
}
