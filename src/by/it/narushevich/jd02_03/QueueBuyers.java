package by.it.narushevich.jd02_03;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class QueueBuyers {

    private QueueBuyers(){
    }

    private static final BlockingQueue<Buyer> BUYERS = new LinkedBlockingDeque<>(30);

    static synchronized void add(Buyer buyer) {
        BUYERS.add(buyer);
    }
    static synchronized Buyer extract() {
        return BUYERS.poll();
    }
}
