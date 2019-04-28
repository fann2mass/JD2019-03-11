package by.it.eslaikouskaya.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {

    private static List<Thread> listCashier = new ArrayList<>();

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        System.out.println("=================market is open");
            for (int i = 1; i <= 2; i++) {
                Cashier cashier = new Cashier(i);
                Thread threadCashier = new Thread(cashier);
                threadCashier.start();
                threads.add(threadCashier);
                listCashier.add(threadCashier);
            }


        int numberBuyer = 0;
        while (!Dispatcher.planComplete()) {
            int count = Util.random(2);
            for (int n = 0; n < count; n++) {
                if (!Dispatcher.planComplete()) {
                    if (numberBuyer % 4 != 0) {
                        Buyer buyer = new Buyer(++numberBuyer, "");
                        buyer.start();
                        threads.add(buyer);
                    } else {
                        Buyer buyer = new Buyer(++numberBuyer, "-pensioner");
                        buyer.start();
                        threads.add(buyer);
                    }
                }
                if (QueueBuyers.buyersInQueue()==11){
                    if(listCashier.size()==2) {
                        Cashier cashier = new Cashier(3);
                        Thread threadCashier = new Thread(cashier);
                        threadCashier.start();
                        threads.add(threadCashier);
                        listCashier.add(threadCashier);
                    }
                }
                if (QueueBuyers.buyersInQueue()==16){
                    if(listCashier.size()==3) {
                        Cashier cashier = new Cashier(4);
                        Thread threadCashier = new Thread(cashier);
                        threadCashier.start();
                        threads.add(threadCashier);
                        listCashier.add(threadCashier);
                    }
                }
                if (QueueBuyers.buyersInQueue()==21){
                    if(listCashier.size()==4) {
                        Cashier cashier = new Cashier(5);
                        Thread threadCashier = new Thread(cashier);
                        threadCashier.start();
                        threads.add(threadCashier);
                        listCashier.add(threadCashier);
                    }
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
        System.out.println("=================market is close");

    }

}

