package by.it.bildziuh.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private QueueBuyers() {
    }

    private static final BlockingDeque<Buyer> buyersQueue = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        if (buyer.pensioneer)
            buyersQueue.addFirst(buyer);
        else
            buyersQueue.addLast(buyer);
//        Dispatcher.buyerInQueue.getAndIncrement();
    }

    static Buyer extract() {
//        Dispatcher.buyerInQueue.getAndDecrement();
        return buyersQueue.poll();
    }

    static int size() {
        return buyersQueue.size();
    }
}
