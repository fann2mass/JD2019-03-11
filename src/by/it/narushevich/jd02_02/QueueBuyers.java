package by.it.narushevich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    private QueueBuyers(){
    }

    private static Deque<Buyer> buyerDeque = new ArrayDeque<>();
    private static Deque<Buyer> pensioneersDeque = new ArrayDeque<>();

    public static Deque<Buyer> getBuyerDeque() {
        return buyerDeque;
    }

    static synchronized void add(Buyer buyer) {
        buyerDeque.addLast(buyer);
    }
    static synchronized void addPensioneer(Buyer buyer) {
        pensioneersDeque.addLast(buyer);
    }

    static synchronized Buyer extract() {
        return buyerDeque.pollFirst();
    }
    static synchronized Buyer extractPensioneer() {
        return pensioneersDeque.pollFirst();
    }


}
