package by.it.eslaikouskaya.jd02_01;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Buyer extends Thread implements IBuyer, IUseBasket{

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }


    Buyer(int number) {
        super("Buyer № "+number);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" start to choose goods");
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
    }

    @Override
    public void takeBasket() {
        System.out.println(this+" take basket");
        int timeout = Util.random(100,200);
        Util.sleep(timeout);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this+" start put goods to basket");
        Util.sleep(Util.random(100, 200));
        Map<String, Double> products = Dispatcher.getGoods();
        Set<String> keySets = products.keySet();
        ArrayList<String> productNames = new ArrayList<>(keySets);

        int goodsInBasket = Util.random(1, 4);
        for (int i = 0; i < goodsInBasket; i++) {
            String productInBasket = productNames.get(Util.random
                    (0, productNames.size() - 1));
            Double value = products.get(productInBasket);
            System.out.println(this + " buy " + productInBasket + ": " + value);
        };
        System.out.println(this+" finish put goods to basket");
    }

    @Override
    public void goOut() {
        System.out.println(this+" go out from the market");
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
