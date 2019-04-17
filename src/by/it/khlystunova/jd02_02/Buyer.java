package by.it.khlystunova.jd02_02;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioneer = false;
    static Integer numberInTheShop = 0;

    Buyer(int number) {
        super("Buyer № " + number+" ");
        if(number%4==0)this.pensioneer=true;
        Dispatcher.newBuyer();
    }


    @Override
    public void run() {
            numberInTheShop++;
            enterToMarket();
            takeBasket();
            chooseGoods();
            putGoodsToBasket();
            addToQueue();
            goOut();
            numberInTheShop--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" Come to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" Start to choose goods");
        if(pensioneer) Util.sleep(Util.random(750,3_000));
        Util.sleep(Util.random(500,2_000));
        System.out.println(this+" Finish to choose goods");

    }

    @Override
    public void addToQueue() {
        System.out.println(this+" added to queue and wait");
        QueueBuyers.add(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this+" complete service at the cashier");
    }


    @Override
    public void goOut() {
        System.out.println(this+" Go out from the market");
        Dispatcher.deleteBuyer();
    }


    @Override
    public String toString() {
        return this.getName()+" "+pensioneer;
    }

    @Override
    public void takeBasket() {
        if(pensioneer) Util.sleep(Util.random(150,300));
        Util.sleep(Util.random(100,200));
        System.out.println(this+" Take a backet");
    }

    @Override
    public void putGoodsToBasket() {
        if(pensioneer) Util.sleep(Util.random(150,300));
        Util.sleep(Util.random(100,200));
        int numberOfGoods = Util.random(1,4);

        Map<String, Double> listOfGoods = Dispatcher.getListOfGoods();
        Set<String> keySets = listOfGoods.keySet();

        ArrayList<String> listOfKeys = new ArrayList<>(keySets);

        for (int i = 0; i < numberOfGoods ; i++) {
            int indexRandom = Util.random(0,listOfKeys.size()-1);
            String chosenGood = listOfKeys.get(indexRandom);
            Double prise = listOfGoods.get(chosenGood);
            System.out.println(this+" Chosen: "+chosenGood+" "+prise);
        }
    }
}
