package by.it.khlystunova.jd02_01;

import java.util.HashMap;


 class Dispatcher {

    final static int kSpeed=100;//спать будем в kspeed раз быстрее
    final static int finishTime=120;

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
