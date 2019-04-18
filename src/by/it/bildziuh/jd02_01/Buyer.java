package by.it.bildziuh.jd02_01;

import java.util.HashMap;
import java.util.Iterator;

public class Buyer extends Thread implements IBuyer, IUseBucket {

    //static int buyersInside = 0;

    @Override
    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        putGoodsToBucket();
        goOut();
    }

    private boolean pensioneer = false;

    Buyer(int number) {
        super("Buyer № " + number);
        if (Util.random(1, 4) == 4)
            this.pensioneer = true;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start to choose goods");
        int timeout = Util.random(500, 2000);
        if (pensioneer)
            timeout *= 3 / 2;
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
    public void takeBucket() {
        int timeout = Util.random(100, 200);
        if (pensioneer)
            timeout *= 3 / 2;
        Util.sleep(timeout);
        System.out.println(this + " took a bucket");

    }

    @Override
    public void putGoodsToBucket() {
        int timeout = Util.random(100, 200);
        if (pensioneer)
            timeout *= 3 / 2;
        Util.sleep(timeout);
        HashMap<String, Double> chosenGoods = new HashMap<>(Dispatcher.listOfGoods);
        Iterator iterator = chosenGoods.entrySet().iterator();
        int size = chosenGoods.size();
        int goodsCount = Util.random(1, 4);
        while (iterator.hasNext() && chosenGoods.size() != goodsCount) {
            iterator.next();
            if (Util.random(1, size) != size) {
                iterator.remove();
                size--;
            }
        }
        System.out.println(this + " putted goods into a bucket");
        System.out.println(chosenGoods);
    }
}
