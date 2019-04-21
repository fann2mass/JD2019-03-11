package by.it.khlystunova.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Market {

    public static void main(String[] args) {

        System.out.println("------------market is opened---------------");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
            for (int i = 1; i <= 5; i++) {
                Cashier cashier = new Cashier(i);
                    executorService.submit(cashier);
            }
        int numberBuyer = 0;
        int time = 0;

        while (!Dispatcher.planComplete()) {
            if (time < 30) {
                int count = Util.random(2);
                if (!(Dispatcher.getBuyerInMarket() >= time + 10)) {
                    for (int n = 0; n < count; n++) {
                        if (!Dispatcher.planComplete()) {
                            Buyer buyer = new Buyer(++numberBuyer);
                            buyer.start();

                        }
                    }
                }
                time++;

            } else  {
                int count = Util.random(2);
                if (Dispatcher.getBuyerInMarket() <= 40 + (30 - time)) {
                    for (int n = 0; n < count; n++) {
                        if (!Dispatcher.planComplete()) {
                            Buyer buyer = new Buyer(++numberBuyer);
                            buyer.start();

                        }
                    }
                }
                time++;
            }
            if(time== Dispatcher.MINUTE)time=0;
            Util.sleep(1000);
        }

        executorService.shutdown();
            while (!executorService.isTerminated()) {
                Util.sleep(10);
            }
        System.out.printf(" TOTAL AMOUNT : %.2f \n",Dispatcher.SUM);
        System.out.println("------------market is closed-------------");
    }
}
