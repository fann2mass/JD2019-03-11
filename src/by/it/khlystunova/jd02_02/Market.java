package by.it.khlystunova.jd02_02;

import java.util.ArrayList;
import java.util.List;


public class Market {

    public static void main(String[] args) {

        System.out.println("market is opened");
        List<Thread> buyers = new ArrayList<>();

        for (int i = 0; i <=2 ; i++) {
            Cashier cashier = new Cashier(1);

        }


        int numberBuyer = 0;
        int time =0;
        for (int countMinuts = 0; countMinuts < 2; countMinuts++) {
            while(Dispatcher.planComplete()){
                if(time<=30) {
                        int count = Util.random(2);
                        if(!(Buyer.numberInTheShop>=time+10)) {
                            for (int n = 0; n < count; n++) {
                                if (!Dispatcher.planComplete()) {
                                    Buyer buyer = new Buyer(++numberBuyer);
                                    numberBuyer++;
                                    buyer.start();
                                    buyers.add(buyer);
                                }
                            }
                        }
                    time++;
                    Util.sleep(1000);

                }else {
                    int count = Util.random(2);
                      if(Buyer.numberInTheShop<=40+(30-time)) {
                        for (int n = 0; n < count; n++) {
                            if (!Dispatcher.planComplete()) {
                                Buyer buyer = new Buyer(++numberBuyer);
                                buyer.start();
                                numberBuyer++;
                                buyers.add(buyer);
                            }
                        }
                      }
                    time++;
                    Util.sleep(1000);
                }
            }
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
