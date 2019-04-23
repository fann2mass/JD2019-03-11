package by.it.khlystunova.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

 class QueueBuyers {

     private QueueBuyers(){}

     private static final Deque<Buyer> buyersDeque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        buyersDeque.addLast(buyer);
    }

     static synchronized Buyer extract(){
         return buyersDeque.pollFirst();
     }

     static synchronized int getSize() {
         return buyersDeque.size();
     }
 }
