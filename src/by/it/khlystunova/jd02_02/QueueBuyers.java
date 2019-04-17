package by.it.khlystunova.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

 class QueueBuyers {

     private QueueBuyers(){}

     private final static Deque<Buyer> buyersDeque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer){
        buyersDeque.addLast(buyer);
    }

     static synchronized Buyer extract(){
         return  buyersDeque.pollFirst();//безопасное извлечение poll,попытается извлечь, если есть кто0то в очереди, если нет вернет null(не ошибку)
     }
}
