package by.it.narushevich.jd02_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Buyer extends Thread implements IBuyer, IUseBacket {

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBasket();
        addToQueue();
        goOut();
    }

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.buyerCounter++;
        Dispatcher.buyerInMarket++;
    }

    static boolean pensioneer = false;

    static int inMarket = 0;

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
    public void addToQueue() {
        System.out.println(this + " added to queue and wait");
        QueueBuyers.add(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " complete service at cashier");
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
        List<String> keysList = new ArrayList<>(Dispatcher.listOfGoods.keySet());
        StringBuilder list = new StringBuilder();
        double sum = 0;
        for (int i = 1; i < numberOfGoods + 1; i++) {
            Collections.shuffle(keysList);
            String randomKey = keysList.get(new Random().nextInt(keysList.size()));
            Double price = Dispatcher.listOfGoods.get(randomKey);
            keysList.remove(randomKey);
            sum += price;
            list.append(randomKey);
            if (i == numberOfGoods) list.append(" - total price is ");
            else list.append(", ");
        }
        System.out.printf("%s put goods: %s%5.2f%n",this,list,sum);
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from the market");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
