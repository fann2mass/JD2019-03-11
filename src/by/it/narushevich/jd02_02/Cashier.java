package by.it.narushevich.jd02_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Cashier implements Runnable {

    private int number;

    public Cashier(int number) {
        this.number = number;
    }

    Object monitorCashier() {
        return this;
    }

    private boolean waitBuyer;

    public void setWaitBuyer(boolean waitBuyer) {
        this.waitBuyer = waitBuyer;
    }

    @Override
    public void run() {
        System.out.println(this+" is opened");
        while (Dispatcher.marketOpened()) {
            Buyer pensioneer = QueueBuyers.extractPensioneer();
            Buyer buyer = QueueBuyers.extract();
            if (pensioneer != null) cashierService(pensioneer);
            else if (buyer != null) cashierService(buyer);
            else synchronized (this) {
                while (waitBuyer) try {
                    wait(10);
                    waitBuyer = Dispatcher.getBuyerInMarket() > 0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this + " is closed");
    }

    private void cashierService(Buyer buyer) {
        synchronized (System.out) {
                System.out.println("=================================");
                System.out.println(this + " started service " + buyer);
                int timeout = Util.random(2000, 5000);
                HashMap<String, Double> myGoods = buyer.getMyGoods();
                double sum = 0;
                Set<Map.Entry<String, Double>> entries = myGoods.entrySet();
                for (Map.Entry<String, Double> entry : entries) {
                    sum += entry.getValue();
                    System.out.println(entry);
                }
                System.out.printf("Total sum of the buy is: %5.2f%n", sum);
                Util.sleep(timeout);
                System.out.println(this + " finished service " + buyer);
                System.out.println("=================================");
        }
        synchronized (buyer.monitorBuyer()) {
            buyer.setWaitService(false);
            buyer.monitorBuyer().notify();
        }
    }

    @Override
    public String toString() {
        return "Cashier №" + number;
    }

}
