package by.it.bildziuh.jd02_03;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    private QueueBuyers() {
    }

    private static final Deque<Buyer> buyerDeque = new ArrayDeque<>();
    private static final Deque<Buyer> pensioneerDeque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
        if (buyer.pensioneer)
            pensioneerDeque.addLast(buyer);
        else
            buyerDeque.addLast(buyer);
    }

    static synchronized Buyer extract() {
        if (pensioneerDeque.size() != 0)
            return pensioneerDeque.pollFirst();
        return buyerDeque.pollFirst();
    }

    static synchronized int size() {
        return buyerDeque.size() + pensioneerDeque.size();
    }
}
