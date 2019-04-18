package by.it.akhmelev.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    private QueueBuyers() {
    }

    private static final Deque<Buyer> buyerDeque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
        buyerDeque.addLast(buyer);
    }

    static synchronized Buyer extract() {
        return buyerDeque.pollFirst();
    }

}
