package by.it.khlystunova.jd02_02;

import java.util.ArrayList;
import java.util.List;


class Market {

    public static void main(String[] args) {

        System.out.println("------------market is opened---------------");
        List<Thread> threads = new ArrayList<>();
         int numberCashiers = 0;

        for (int i = 0; i < 5 ; i++) {
            Cashier cashier = new Cashier(++numberCashiers);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            threads.add(threadCashier);

        }

            int numberBuyer = 0;
            int time = 0;

                while (!Dispatcher.planComplete()) {
                    if (time <= 30) {
                        int count = Util.random(2);
                        if (!(Dispatcher.getBuyerInMarket() >= time + 10)) {
                            for (int n = 0; n < count; n++) {
                                if (!Dispatcher.planComplete()) {
                                    Buyer buyer = new Buyer(++numberBuyer);
                                    buyer.start();
                                    threads.add(buyer);
                                }
                            }
                        }
                        time++;
                        Util.sleep(1000);

                    } else {
                        int count = Util.random(2);
                        if (Dispatcher.getBuyerInMarket() <= 40 + (30 - time)) {
                            for (int n = 0; n < count; n++) {
                                if (!Dispatcher.planComplete()) {
                                    Buyer buyer = new Buyer(++numberBuyer);
                                    buyer.start();
                                    threads.add(buyer);
                                }
                            }
                        }
                        time++;
                        Util.sleep(1000);
                    }
                    if(time==Dispatcher.MINUTE)time=0;
                }

        for (Thread buyer : threads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("------------market is closed-------------");
    }
}
