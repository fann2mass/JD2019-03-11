package by.it.narushevich.jd02_03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private QueueBuyers(){
    }

    private static final BlockingQueue<Buyer> BUYERS = new LinkedBlockingDeque<>(30);

    public static BlockingQueue<Buyer> getBUYERS() {
        return BUYERS;
    }

    static synchronized void add(Buyer buyer) {
        BUYERS.add(buyer);

    }
    static synchronized Buyer extract() {
        return BUYERS.poll();
    }
}
