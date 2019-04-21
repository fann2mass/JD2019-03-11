package by.it.khlystunova.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private QueueBuyers(){}

    private static final BlockingDeque<Buyer> BUYERS_QUEUE = new LinkedBlockingDeque<>(30);


    static  void add(Buyer buyer){
        BUYERS_QUEUE.addLast(buyer);
    }

    static Buyer extract(){
        return BUYERS_QUEUE.pollFirst();
    }

    static  int getSize() {
        return BUYERS_QUEUE.size();
    }
}
