package by.it.vasiliuk.jd02_02;

        import java.util.HashMap;

@SuppressWarnings("all")
class Dispatcher {

    private static final Object monitorCounters = new Object();
    private static final Object monitorCashiers = new Object();

    static final int K_SPEED =100;
    private static final int PLAN = 100;
    private static  volatile int buyerCounter = 0;
    private static volatile  int buyerInMarket = 0;
    private static  volatile int cashiersCounter = 0;


    static final int MINUTE = 60;

    static boolean marketOpened() {
        return buyerCounter < PLAN || buyerInMarket > 0;
    }

    static void newBuyer() {
        synchronized (monitorCounters) {
            buyerCounter++;
            buyerInMarket++;
        }
    }

    static void deleteBuyer() {
        synchronized (monitorCounters) {
            buyerInMarket--;
        }
    }

    static void newCashier() {
        synchronized (monitorCashiers) {
            cashiersCounter++;
        }
    }

    static void deleteCashier() {
        synchronized (monitorCashiers) {
            cashiersCounter--;
        }
    }

    static int getBuyerInMarket(){
        return buyerInMarket;
    }

    static  boolean planComplete(){
        return buyerCounter == PLAN;
    }


    private static HashMap<String,Double> listOfGoods = new HashMap<String,Double>(){{
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

    static HashMap<String, Double> getListOfGoods() {
        return new HashMap<>(listOfGoods);
    }

}