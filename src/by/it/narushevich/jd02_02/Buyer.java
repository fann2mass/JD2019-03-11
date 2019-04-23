package by.it.narushevich.jd02_02;

import java.util.*;

class Buyer extends Thread implements IBuyer, IUseBasket {

    Buyer(int number) {
        super("Buyer №" + number);
        if (number % 4 == 0) {
            pensioneer = true;
            this.setName("Buyer №" + number + " pensioneer" );}
        Dispatcher.newBuyer();
    }

    Basket basket = new Basket(this);

    private HashMap<String, Double> myGoods = basket.putGoods();

    public HashMap<String, Double> getMyGoods() {
        return myGoods;
    }

    Object monitorBuyer() {
        return this;
    }

    private boolean waitService;

    public void setWaitService(boolean waitService) {
        this.waitService = waitService;
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
        int timeout = Util.random(100, 200);
        if (pensioneer) {
            int newTimeOut = (timeout * 3) / 2;
            Util.sleep(newTimeOut);
        } else Util.sleep(timeout);
        System.out.println(this + " take basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start to choose goods");
        int timeout = Util.random(500, 2000);
        if (pensioneer) {
            int newTimeOut = (timeout * 3) / 2;
            Util.sleep(newTimeOut);
        } else Util.sleep(timeout);
        System.out.println(this + " finish to choose goods");
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
        if (pensioneer){QueueBuyers.addPensioneer(this);}
        else QueueBuyers.add(this);
        waitService = true;
        Cashier cashier = QueueCashiers.extract();
        if (cashier != null) {
            synchronized (cashier.monitorCashier()) {
                cashier.setWaitBuyer(false);
                cashier.monitorCashier().notify();
            }
            QueueCashiers.add(cashier);
        }
        else synchronized (this) {
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
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
