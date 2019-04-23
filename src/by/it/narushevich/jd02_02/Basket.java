package by.it.narushevich.jd02_02;

import java.util.*;

class Basket {

    public Basket(Buyer buyer) {
    }

    HashMap<String,Double> putGoods() {
        int numberOfGoods = Util.random(1, 4);
        List<String> keysList = new ArrayList<>(Dispatcher.getListOfGoods().keySet());
        HashMap<String, Double> myList = new HashMap<>();
        for (int i = 1; i < numberOfGoods + 1; i++) {
            Collections.shuffle(keysList);
            String randomKey = keysList.get(new Random().nextInt(keysList.size()));
            Double price = Dispatcher.getListOfGoods().get(randomKey);
            keysList.remove(randomKey);
            myList.put(randomKey, price);
        }
        return myList;
    }
}
