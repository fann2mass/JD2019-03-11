package by.it.khlystunova.jd02_02;

import java.util.HashMap;

@SuppressWarnings("all")
class Dispatcher {

   private static final Object monitorCounters = new Object();
   private static final Object monitorCashiers = new Object();

   static final int K_SPEED =100;//спать будем в kspeed раз быстрее
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

    /*static boolean needCashiers() {
      boolean res;
      synchronized (monitorCashiers) {
          int n = cashiersCounter;
          res = (n * 5 < QueueBuyers.getSize());
         if (cashiersCounter >= 5 )
            res = false;
      }
        return res;
    }*/


    private static HashMap<String,Double> listOfGoods = new HashMap<String,Double>(){{
       put("Milk", 1.68);
       put("Jam", 3.46);
       put("Broad", 0.70);
       put("Butter", 2.58);
       put("Candy", 2.48);
       put("Orange", 1.45);
       put("Apple", 0.54);
       put("Cheese", 3.04);
       put("Crisp", 2.20);
       put("Porridge", 1.50);

   }};

     static HashMap<String, Double> getListOfGoods() {
        return new HashMap<>(listOfGoods);
   }

}
