package by.it.eslaikouskaya.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {

        List<Thread> buyers = new ArrayList<>();
        System.out.println("=================market is open");

        int time = 0;
        int numberBuyer = 0;
        while (time < Dispatcher.finishTime) {
            int count = Util.random(2);
            for (int n = 0; n < count; n++) {
                if (numberBuyer%4!=0){
                    Buyer buyer = new Buyer(++numberBuyer, "");
                    buyer.start();
                    buyers.add(buyer);}
                else {
                    Buyer buyer = new Buyer(++numberBuyer, "-pensioner");
                    buyer.start();
                    buyers.add(buyer);
                }
	            if (time > 30 && Dispatcher.buyerInMarket <= 30 + (30 - time))
		            continue;

	            if (time <= 30 && Dispatcher.buyerInMarket <= time + 5)
		            continue;

	            Util.sleep(1000);
	            time++;
            }
            time++;
            Util.sleep(1000);
        }

        for (Thread th : buyers) {
            try {
                th.join();
            } catch (InterruptedException e) {
                System.out.println("wow");
            }
        }
        System.out.println("=================market is close");

    }

}

