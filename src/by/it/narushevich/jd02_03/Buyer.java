package by.it.narushevich.jd02_03;

import java.util.*;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private  boolean waitService;

    public void setWaitService(boolean waitService) {
        this.waitService = waitService;
    }

    Object monitorBuyer() {
        return this;
    }

    Buyer(int number) {
        super("Buyer №" + number);
        if (number % 4 == 0) pensioneer = true;
        Dispatcher.newBuyer();
    }
    Semaphore shopping = new Semaphore(20);
    Semaphore tookBasket = new Semaphore(50);

    Basket basket = new Basket(this);

    private HashMap<String, Double> myGoods = basket.putGoods();

    public HashMap<String, Double> getMyGoods() {
        return myGoods;
    }

    boolean pensioneer = false;

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        addToQueue();
        goOut();
    }


    @Override
    public void enterToMarket() {
        System.out.println(this + " came to the market");

    }

    @Override
    public void takeBasket() {
        try {
            tookBasket.acquire();
            int timeout = Util.random(100, 200);
            if (pensioneer) {
                int newTimeOut = (timeout * 3) / 2;
                Util.sleep(newTimeOut);
            } else Util.sleep(timeout);
            System.out.println(this + " take basket");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void chooseGoods() {
        try {
            shopping.acquire();
            System.out.println(this + " start to choose goods");
            int timeout = Util.random(500, 2000);
            if (pensioneer) {
                int newTimeOut = (timeout * 3) / 2;
                Util.sleep(newTimeOut);
            } else Util.sleep(timeout);
            System.out.println(this + " finish to choose goods");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBasket() {
        int timeout = Util.random(100, 200);
        System.out.println(this.toString() + " bought: " + myGoods);
        if (pensioneer) {
            int newTimeOut = (timeout * 3) / 2;
            Util.sleep(newTimeOut);
        } else {
            Util.sleep(timeout);
        }
    }

    @Override
    public void addToQueue() {
        System.out.println(this + " added to queue and wait");
        try {
            QueueBuyers.add(this);
        }
        catch (IllegalStateException e){
            System.out.println(this + " can't add to deque, deque full");
            Util.sleep(1000);
        }
        shopping.release();
        waitService = true;
        synchronized (this) {
            while (waitService) try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(this + " complete service at cashier");
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from the market");
        Dispatcher.deleteBuyer();
        tookBasket.release();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
