package by.it.vasiliuk.jd02_03;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
@SuppressWarnings("all")
class Dispatcher {

    static ExecutorService executorService = Executors.newFixedThreadPool(5);

    static final int K_SPEED =1000;
    private static final int PLAN = 100;
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);
    static final AtomicInteger cashiersCounter = new AtomicInteger(0);

    static  double SUM = 0;


    static final int MINUTE = 60;

    static boolean marketOpened() {
        return buyerCounter.get() < PLAN || buyerInMarket.get() > 0;
    }

    static void newBuyer() {
        buyerCounter.getAndIncrement();
        buyerInMarket.getAndIncrement();
    }

    static void deleteBuyer() {
        buyerInMarket.getAndDecrement();
    }

    static int getBuyerInMarket(){
        return buyerInMarket.get();
    }

    static  boolean planComplete(){
        return buyerCounter.get() == PLAN;
    }



    static boolean needCashiers() {
        boolean res;
        res = (cashiersCounter.get()*5 <QueueBuyers.getBuyers().size());
        if (!res && cashiersCounter.get() == 1)
            res = !Dispatcher.planComplete();
        if (cashiersCounter.get() >= 5)
            res = false;
        return res;
    }


    private static final ConcurrentHashMap<String,Double> LIST_OF_GOODS = new ConcurrentHashMap<String, Double>(){{
        put("Onion", 3.99);
        put("Crisps", 7.99);
        put("Garlic", 3.49);
        put("Cheese", 9.99);
        put("Cake", 2.99);
        put("Chicken", 4.49);
        put("Jelly", 2.99);
        put("Water", 14.49);
        put("Soda", 6.49);

    }};

    static ConcurrentHashMap<String, Double> getListOfGoods() {
        return LIST_OF_GOODS;
    }

    static void executorShutDown() {
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Util.sleep(10);
        }
    }


}
