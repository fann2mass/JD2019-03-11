package by.it.bildziuh.jd02_03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBucket {

    private static Semaphore chosingGoods = new Semaphore(20);
    private static Semaphore bucketPicked = new Semaphore(50);

    HashMap<String, Double> paymentCheck = new HashMap<>();

    @Override
    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        putGoodsToBucket();
        addToQueue();
        goOut();
    }

    Object getMonitor() {
        return this;
    }

    boolean pensioneer = false;
    private boolean wait;

    Buyer(int number) {
        super("Buyer № " + number);
        if (Util.random(1, 4) == 4)
            this.pensioneer = true;
        Dispatcher.newBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market");
    }

    void setWait(boolean wait) {
        this.wait = wait;
    }

    @Override
    public void chooseGoods() {
        try {
            chosingGoods.acquire();
            System.out.println(this + " start to choose goods");
            int timeout = Util.random(500, 2000);
            if (pensioneer)
                timeout *= 3 / 2;
            Util.sleep(timeout);
            System.out.println(this + " finish to choose goods");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            chosingGoods.release();
        }
    }

    @Override
    public void addToQueue() {
        while (true) {
            if (QueueBuyers.size() < 30) {
                QueueBuyers.add(this);
                break;
            } else {
                //              System.err.println(this + " waiting queue is full");
                Util.sleep(10);
            }
        }
        System.out.println(this + " added to queue and wait");
        wait = true;
        synchronized (this) {
            while (wait)
                try {
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
        bucketPicked.release();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBucket() {
        try {
            bucketPicked.acquire();
            int timeout = Util.random(100, 200);
            if (pensioneer)
                timeout *= 3 / 2;
            Util.sleep(timeout);
            System.out.println(this + " took a bucket");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bucketPicked.release();
        }
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
        while (iterator.hasNext() && chosenGoods.size() != Util.random(1, 4)) {
            iterator.next();
            if (Util.random(1, size) != size) {
                iterator.remove();
                size--;
            }
        }
        System.out.println(this + " putted goods into a bucket");
        paymentCheck.putAll(chosenGoods);
    }
}

