package by.it.vasiliuk.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private QueueBuyers(){}

    private static final BlockingDeque<Buyer> BUYERS_QUEUE = new LinkedBlockingDeque<>(30);


    static  void add(Buyer buyer) {
        if(buyer.isPensionner())
            BUYERS_QUEUE.addFirst(buyer);
        BUYERS_QUEUE.addLast(buyer);
        if (Dispatcher.needCashiers()) {
            Dispatcher.executorService.execute(new Cashier());
        }
    }

    static Buyer extract(){
        return BUYERS_QUEUE.pollFirst();
    }

    static  BlockingDeque<Buyer>  getBuyers() {
        return BUYERS_QUEUE;
    }

    static boolean needService() {
        boolean needService;
        needService = (QueueBuyers.getBuyers().size() > 0);
        return needService;
    }
}