package by.it.khlystunova.jd02_01;

import java.util.ArrayList;
import java.util.List;


public class Market {

    public static void main(String[] args) {

        System.out.println("market is opened");
        List<Thread> buyers = new ArrayList<>();

        int time = 0;
        int numberBuyer = 0;
        //нам нужно поспать 120 раз по секунде чтобы было 2 минуты в общем
        while(time<Dispatcher.finishTime){
            int count = Util.random(2);
            for (int n = 0; n < count; n++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
                buyers.add(buyer);
            }
            time++;
            //спим секунду прежде чем запустить новую партию покупателей в магазин
            Util.sleep(1000);
        }
        for (Thread buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("market is closed");
    }
}
