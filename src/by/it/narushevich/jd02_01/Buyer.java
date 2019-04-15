package by.it.narushevich.jd02_01;

import java.util.*;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start to choose goods");
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + " finish to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from the market");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        int timeout = Util.random(100, 200);
        System.out.println(this + " take backet");
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.random(100, 200);
        int numberOfGoods = Util.random(1, 4);
        List<String> keysList = new ArrayList<>(Dispatcher.listOfGoods.keySet());
        StringBuilder list = new StringBuilder();
        int sum=0;
        for (int i = 1; i < numberOfGoods+1; i++) {
            String randomKey = keysList.get(new Random().nextInt(keysList.size()));
            Integer price = Dispatcher.listOfGoods.get(randomKey);
            sum+=price;
            list.append(randomKey);
            if (i == numberOfGoods) list.append(" - total price is ").append(sum);
            else list.append(", ");
        }
        System.out.println(this + " chose goods: "+list);
    }
}
