package by.it.bildziuh.jd02_02;

import java.util.Arrays;
import java.util.HashMap;


class Cashier implements Runnable {

    private static double income = 0;

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (Dispatcher.marketOpened()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                synchronized (System.out) {
                    System.out.println(this + " started service " + buyer);
                    int timeout = Util.random(2000, 5000);
                    Util.sleep(timeout);
                    System.out.println(this + " finished service " + buyer);
                    printCheck(buyer);
                }
                synchronized (buyer.getMonitor()) {
                    buyer.getMonitor().notify();
                }
            }
        }
        System.out.println(this + " closed");
    }

    private synchronized void printCheck(Buyer buyer) {

        double total = 0;
        char[] tabCashierCh = new char[22 * (number - 1)];
        char[] tabCh = new char[92 - 22 * (number - 1)];
        Arrays.fill(tabCashierCh, ' ');
        Arrays.fill(tabCh, ' ');
        String tabCashier = new String(tabCashierCh);
        String tab = new String(tabCh);
        String line = "------------------";
        System.out.printf("%s%s%s%s\t%s\n", tabCashier, line, tab, line, line);
        System.out.printf("%s| %-13s |%s| In queue %-5s | \t| Total income%-2s |\n", tabCashier, buyer, tab, " ", " ");
        System.out.printf("%s%s%s%s\t%s\n", tabCashier, line, tab, line, line);
        for (HashMap.Entry<String, Double> entry : buyer.paymentCheck.entrySet()) {
            total += entry.getValue();
            System.out.printf("%s| %-6s = %-5.2f |%s| %-14s |\t| %-14s |\n", tabCashier, entry.getKey(), entry.getValue(), tab, " ", " ");
        }
        income += total;
        System.out.printf("%s%s%s%s\t%s\n", tabCashier, line, tab, line, line);
        System.out.printf("%s| Total  = %-5.2f |%s| %-14s |\t| %-14.2f |\n", tabCashier, total, tab, QueueBuyers.size(), income);
        System.out.printf("%s%s%s%s\t%s\n", tabCashier, line, tab, line, line);
    }

    @Override
    public String toString() {
        return "-- Cashier №" + number;
    }
}
