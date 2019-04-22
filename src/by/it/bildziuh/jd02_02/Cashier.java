package by.it.bildziuh.jd02_02;

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
                    buyer.getMonitor().notify();
                }
            }
        }
        System.out.println(this + " closed");
    }

    private void printCheck(Buyer buyer) {

        double total = 0;
        char[] tabCashierCh = new char[22 * (number - 1)]; //22 =  18 (ширина столбца) + 4(табуляция), умножается на количество стоблбцов -1, т.к. первый столбец без отступа
        char[] tabCh = new char[92 - 22 * (number - 1)]; //92 = ширина столбца умножается на максимальное кол-во столбцов минус один, и потом плюс 4 символа, вместо табуляции
        Arrays.fill(tabCashierCh, ' ');
        Arrays.fill(tabCh, ' ');
        String tabCashier = new String(tabCashierCh);
        String tab = new String(tabCh);
        String line = "------------------";
        String border = tabCashier + line + tab + line + "\t" + line;
        //    synchronized (System.out) {
        System.out.println(border);
        System.out.printf("%s| %-13s |%s| In queue %-5s | \t| Total income%-2s |\n", tabCashier, buyer, tab, " ", " ");
        System.out.println(border);
        for (HashMap.Entry<String, Double> entry : buyer.paymentCheck.entrySet()) {
            total += entry.getValue();
            System.out.printf("%s| %-6s = %-5.2f |%s| %-14s |\t| %-14s |\n", tabCashier, entry.getKey(), entry.getValue(), tab, " ", " ");
        }
        Util.income += total;
        System.out.println(border);
        System.out.printf("%s| Total  = %-5.2f |%s| %-14s |\t| %-14.2f |\n", tabCashier, total, tab, QueueBuyers.size(), Util.income);
        System.out.println(border);
        //    }
    }

    @Override
    public String toString() {
        return "-- Cashier №" + number;
    }
}
