package by.it.vasiliuk.jd02_02;

import java.util.HashMap;
import java.util.Iterator;

class Buyer extends Thread implements IBuyer, IBucket {

    private static final Object sync = new Object();

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

    private boolean pensioneer = false;

    Buyer(int number) {
        super("Buyer № " + number);
        if (Util.random(1, 4) == 4)
            this.pensioneer = true;
        Dispatcher.newBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choosing goods");
        int timeout = Util.random(500, 2000);
        if (pensioneer)
            timeout *= 3 / 2;
        Util.sleep(timeout);
        System.out.println(this + " finished choosing goods");
    }

    @Override
    public void addToQueue() {
        System.out.println(this + " added to queue and waiting");
        QBuyers.add(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        print();
        System.out.println(this + " completed servicing at cashier");


    }

    @Override
    public void goOut() {
        System.out.println(this + " left market");
        Dispatcher.deleteBuyer();
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
        while (iterator.hasNext() && chosenGoods.size() != Util.random(1, 4)) {
            iterator.next();
            if (Util.random(1, size) != size) {
                iterator.remove();
                size--;
            }
        }
        System.out.println(this + " put goods into a bucket");
        paymentCheck.putAll(chosenGoods);
    }

    private void print() {
        double total = 0;
        System.out.println("------------------");
        System.out.printf(" %-13s |\n", this);
        System.out.println("------------------");
        for (HashMap.Entry<String, Double> entry : paymentCheck.entrySet()) {
            total += entry.getValue();
            System.out.printf(" %-6s = %-5.2f |\n", entry.getKey(), entry.getValue());
        }
        System.out.println("------------------");
        System.out.printf(" Total price = %-5.2f  |\n", total);
        System.out.println("------------------");

    }
}
