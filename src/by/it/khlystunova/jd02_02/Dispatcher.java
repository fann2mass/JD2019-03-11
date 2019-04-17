package by.it.khlystunova.jd02_02;

import java.util.HashMap;


class Dispatcher {

   final static int kSpeed=100;//спать будем в kspeed раз быстрее
   final static int finishTime=60;
   final static int plan = 100;
   private static  volatile int buyerCounter = 0;
   private static volatile   int buyerInMarket = 0;
   static boolean marketOpened(){//для этого места ставим волотаил выше
      return buyerCounter<plan ||buyerInMarket>0;
   }
   static synchronized void newBuyer(){
      buyerCounter++;
      buyerInMarket++;
   }

   static synchronized void deleteBuyer(){
      buyerInMarket--;
   }

   static  boolean planComplete(){
      return buyerCounter == plan;
   }

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
           return listOfGoods;
   }

}
