package by.it.khlystunova.jd02_01;

import java.util.*;

public class Buyer extends Thread implements IBuyer,IUseBasket {

    Buyer(int number) {
        super("Buyer № "+number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" Come to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" Start to choose goods");
        Util.sleep(Util.random(500,2_000));
        System.out.println(this+" Finish to choose goods");

    }

    @Override
    public void goOut() {
        System.out.println(this+" Go out from the market");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        Util.sleep(Util.random(100,200));
        System.out.println(this+" Take a backet");
    }

    @Override
    public void putGoodsToBasket() {

        Util.sleep(Util.random(100,200));
        int numberOfGoods = Util.random(1,4);

        Map<String, Double> listOfGoods = Dispatcher.getListOfGoods();
        Set<String> keySets = listOfGoods.keySet();

        ArrayList<String> listOfKeys = new ArrayList<>(keySets);

        for (int i = 0; i < numberOfGoods ; i++) {
            int indexRandom = Util.random(0,listOfKeys.size()-1);
            String chosenGood = listOfKeys.get(indexRandom);
            Double prise = listOfGoods.get(chosenGood);
            System.out.println(this+" Chosen: "+chosenGood+" "+prise);
        }
    }
}
