package by.it.narushevich.jd02_01;

import java.util.*;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    boolean pensioneer = false;
    static int inMarket = 0;

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    Buyer(int number) {
        super("Buyer №" + number);
        if (number % 4 == 0){
            pensioneer = true;
        }
        inMarket++;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " came to the market");

    }

    @Override
    public void takeBacket() {
        int timeout = Util.random(100, 200);
        if (pensioneer) {
            int newTimeOut = (timeout * 3)/2;
            Util.sleep(newTimeOut);
        } else Util.sleep(timeout);
        System.out.println(this + " take basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start to choose goods");
        int timeout = Util.random(500, 2000);
        if (pensioneer) {
            int newTimeOut = (timeout * 3)/2;
            Util.sleep(newTimeOut);
        } else Util.sleep(timeout);
        System.out.println(this + " finish to choose goods");
    }

    @Override
    public void putGoodsToBasket() {
        int timeout = Util.random(100, 200);
        if (pensioneer) {
            int newTimeOut = (timeout * 3)/2;
            putGoods();
            Util.sleep(newTimeOut);
        } else {
            putGoods();
            Util.sleep(timeout);
        }
    }

    private void putGoods() {
        int numberOfGoods = Util.random(1, 4);
        List<String> keysList = new ArrayList<>(Dispatcher.getListOfGoods().keySet());
        StringBuilder list = new StringBuilder();
        for (int i = 1; i < numberOfGoods + 1; i++) {
            Collections.shuffle(keysList);
            String randomKey = keysList.get(new Random().nextInt(keysList.size()));
            Double price = Dispatcher.getListOfGoods().get(randomKey);
            keysList.remove(randomKey);
            list.append(randomKey).append(" = ").append(price);
            if (i == numberOfGoods) list.append('.');
            else list.append(", ");
        }
        System.out.printf("%s put goods: %s%n",this,list);
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from the market");
        inMarket--;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
