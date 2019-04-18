package by.it.bildziuh.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Buyer extends Thread implements IBuyer, IUseBucket {

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
        if (Util.random(0, 3) == 3)
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
        Util.sleep(timeout);
        System.out.println(this + " took a bucket");

    }

    @Override
    public void putGoodsToBucket() {
        int timeout = Util.random(100, 200);
        Util.sleep(timeout);
        pickUpGoods();
        System.out.println(this + " putted goods into a bucket");

    }

    private void pickUpGoods() {
        HashMap<String, Double> listOfGoods = new HashMap<String, Double>() {
            {
                put("Soda", 3.99);
                put("Beer", 7.99);
                put("Cereal", 3.49);
                put("Frozen dinners", 9.99);
                put("Snacks", 2.99);
                put("Milk", 4.49);
                put("Bread", 2.99);
                put("Meat", 14.49);
                put("Pasta", 6.49);
            }
        };

        int goods = Util.random(0, 3);
        HashMap<String, Double> choosedGoods = new HashMap<>();
        Set<String> keySet = listOfGoods.keySet();
        ArrayList<String> keys = new ArrayList<>(keySet);


        for (int i = 0; i <= goods; i++) {
            int thing = Util.random(0, keys.size() - 1);

        }
    }
}
