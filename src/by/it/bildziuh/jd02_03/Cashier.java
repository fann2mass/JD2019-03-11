package by.it.bildziuh.jd02_03;

import java.util.Arrays;
import java.util.HashMap;


class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number = number;
    }


    @Override
    public void run() {
        while (Dispatcher.marketOpened()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " started service " + buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this + " finished service " + buyer);
                synchronized (System.out) {
                    printCheck(buyer);
                }
                synchronized (buyer.getMonitor()) {
                    buyer.setWait(false);
                    buyer.getMonitor().notify();
                }
            }
        }
        System.out.println(this + " closed");
    }

    private void printCheck(Buyer buyer) {
        double total = 0;
        String preCheckTab = stringFill((Dispatcher.checkWidth + Dispatcher.checkTab) * (number - 1), ' ');
        String postCheckTab = stringFill((Dispatcher.cashierMax - number) * (Dispatcher.checkWidth + Dispatcher.checkTab) + Dispatcher.checkTab, ' ');
        String tab = stringFill(Dispatcher.checkTab, ' ');
        String line = stringFill(Dispatcher.checkWidth, '-');
        String border = preCheckTab + line + postCheckTab + line + tab + line;

        System.out.printf("%s\n%s| %-13s |%s| In queue %-5s |%s| Total income%-2s |\n%s\n",
                border,
                preCheckTab, buyer, postCheckTab, " ", tab, " ",
                border
        );

        for (HashMap.Entry<String, Double> entry : buyer.paymentCheck.entrySet()) {
            total += entry.getValue();
            System.out.printf("%s| %-6s = %-5.2f |%s| %-14s |%s| %-14s |\n", preCheckTab, entry.getKey(), entry.getValue(), postCheckTab, " ", tab, " ");
        }

        Dispatcher.income += total;

        System.out.printf("%s\n%s| Total  = %-5.2f |%s| %-14s |%s| %-14.2f |\n%s\n",
                border,
                preCheckTab, total, postCheckTab, QueueBuyers.size(), tab, Dispatcher.income,
                border
        );
    }

    private String stringFill(int length, char symbol) {
        char[] charArray = new char[length];
        Arrays.fill(charArray, symbol);
        return new String(charArray);
    }

    @Override
    public String toString() {
        return "-- Cashier №" + number;
    }
}
