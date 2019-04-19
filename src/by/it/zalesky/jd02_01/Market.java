package by.it.zalesky.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Market {
    public static void main(String[] args) {

        List<Thread> buyers = new ArrayList<>();
        System.out.println("Магазин открыт");

        HashMap<String, Integer> hm = new HashMap<String, Integer>(3){
            {
                this.put("Хлеб", 3);
                this.put("Молоко", 4);
                this.put("Пряник", 2);
                this.put("Сырок", 1);

            }

        };


        int time = 0;
        int numberOfBuyers = 0;
        int BuyersWithBacket = 0;
        int Goods = 0;

        while (time<Dispatcher.finishTime){
            int count = Util.random(2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++numberOfBuyers);
                buyer.start();
                buyers.add(buyer);
            }
            time++;
            Util.Sleep(1000);
        }

        for (Thread th : buyers){
            try {
                    th.join();
            } catch (InterruptedException e) {
                System.out.println("ого");
            }

        }

        System.out.println("===========магазин закрыт");
    }
}
