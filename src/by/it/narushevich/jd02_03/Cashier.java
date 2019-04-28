package by.it.narushevich.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Cashier implements Runnable {

    private int number;

    public Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (Dispatcher.marketOpened()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) cashierService(buyer);
        }
        System.out.println(this + " is closed");
    }

    String space;
    String space2;
    String space3;

    private void cashierService(Buyer buyer) {
        synchronized (System.out) {
            switch (this.toString()) {
                case "Cashier №1": {
                    space = "";
                    space2 = "                                                                                                         ";
                    space3 = "                                                                                                                    ";
                    printTable(buyer);
                    break;
                }
                case "Cashier №2": {
                    space = "                     ";
                    space2 = "                                                                                    ";
                    space3 = "                                                                                               ";
                    printTable(buyer);
                    break;
                }
                case "Cashier №3": {
                    space = "                                          ";
                    space2 = "                                                               ";
                    space3 = "                                                                          ";
                    printTable(buyer);
                    break;
                }
                case "Cashier №4": {
                    space = "                                                               ";
                    space2 = "                                          ";
                    space3 = "                                                       ";
                    printTable(buyer);
                    break;
                }
                case "Cashier №5": {
                    space = "                                                                                    ";
                    space2 = "                     ";
                    space3 = "                                ";
                    printTable(buyer);
                    break;
                }
                default:
                    System.out.println("nothing works!!!!");
            }
        }
        synchronized (buyer.monitorBuyer()) {
            buyer.setWaitService(false);
            buyer.monitorBuyer().notify();
        }
    }

    private void printTable(Buyer buyer) {
        System.out.println("\n"+space + this + " started" +space2+ " Buyers  " + "     Market  ");
        System.out.println(space + "service " + buyer +space2+ " in queue " + "    revenue ");
        if (buyer.pensioneer) System.out.println(space+"pensioneer");
        System.out.printf("%s====================%s%2d%n",space,space2,QueueBuyers.getBUYERS().size());
        int timeout = Util.random(2000, 5000);
        HashMap<String, Double> myGoods = buyer.getMyGoods();
        double sum = 0;

        Set<Map.Entry<String, Double>> entries = myGoods.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            sum += entry.getValue();
            Dispatcher.SUM += entry.getValue();
            System.out.println(space + entry);
        }
        System.out.printf("%sTotal sum is: %5.2f%n", space, sum);
        Util.sleep(timeout);
        System.out.printf("%s====================%s%7.2f%n",space,space3,Dispatcher.SUM);
        System.out.println(space + this + " finished");
        System.out.println(space + "service " + buyer+"\n");
    }

    @Override
    public String toString() {
        return "Cashier №" + number;
    }
}
