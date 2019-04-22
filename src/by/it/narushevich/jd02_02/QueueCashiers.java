package by.it.narushevich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCashiers {

    private QueueCashiers(){
    }

    private static Deque<Cashier> marketsCashiers = new ArrayDeque<>();

    public static Deque<Cashier> getMarketsCashiers() {
        return marketsCashiers;
    }

    static synchronized void add(Cashier cashier){marketsCashiers.add(cashier);}

    static synchronized Cashier extract() {
        return marketsCashiers.poll();
    }
}
