package by.it.akhmelev.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private QueueBuyers() {
    }

    private static final BlockingDeque<Buyer> BUYERS = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        BUYERS.addLast(buyer);
    }

    static Buyer extract() {
        return BUYERS.pollFirst();
    }

}
