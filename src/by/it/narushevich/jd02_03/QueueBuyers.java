package by.it.narushevich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private QueueBuyers() {
    }

    private static final BlockingDeque<Buyer> BUYERS = new LinkedBlockingDeque<>(30);

    public static BlockingQueue<Buyer> getBUYERS() {
        return BUYERS;
    }

    static synchronized void add(Buyer buyer) {
        BUYERS.add(buyer);
        if (buyer.pensioneer) BUYERS.addFirst(buyer);
    }

    static synchronized Buyer extract() {
        return BUYERS.poll();
    }
}
