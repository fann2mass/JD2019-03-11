package by.it.eslaikouskaya.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Market {

    private static List<Cashier> listCashier = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("=================market is open");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
                Cashier cashier = new Cashier(i);
                executorService.execute(cashier);
                listCashier.add(cashier);
            }


        int numberBuyer = 0;
        while (!Dispatcher.planComplete()) {
            int count = Util.random(2);
            for (int n = 0; n < count; n++) {
                if (!Dispatcher.planComplete()) {
                    if (numberBuyer % 4 != 0) {
                        Buyer buyer = new Buyer(++numberBuyer, "");
                        buyer.start();
                    } else {
                        Buyer buyer = new Buyer(++numberBuyer, "-pensioner");
                        buyer.start();
                    }
                }
                if (QueueBuyers.buyersInQueue()==11){
                    if(listCashier.size()==2) {
                        Cashier cashier = new Cashier(3);
                        executorService.execute(cashier);
                        listCashier.add(cashier);
                    }
                }
                if (QueueBuyers.buyersInQueue()==16){
                    if(listCashier.size()==3) {
                        Cashier cashier = new Cashier(4);
                        executorService.execute(cashier);
                        listCashier.add(cashier);
                    }
                }
                if (QueueBuyers.buyersInQueue()==21){
                    if(listCashier.size()==4) {
                        Cashier cashier = new Cashier(5);
                        executorService.execute(cashier);
                        listCashier.add(cashier);
                    }
                }
            }
            Util.sleep(1000);
        }


        executorService.shutdown();
        while (!executorService.isTerminated())
            Util.sleep(1);
        System.out.println("=================market is close");

    }

}

