package by.it.vasiliuk.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Buyer extends Thread implements IBuyer, IBucket {

    private boolean pensioneer = false;
    HashMap<String,Double> basket = new HashMap<>();

    Object getMonitor(){
        return this;
    }

    Buyer(int number) {
        super("Customer № " + number);
        if(number%4==0)this.pensioneer = true;
        Dispatcher.newBuyer();
    }


    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        addToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" Entered the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" Start choosing goods");
        if(pensioneer) Util.sleep(Util.random(750,3_000));
        Util.sleep(Util.random(500,2_000));
        System.out.println(this+" Finish choosing goods");

    }

    @Override
    public void addToQueue() {
        System.err.println(this+" added to queue and waiting");
        if(pensioneer)QueuePensionners.add(this);
        else QueueBuyers.add(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(this+" finished with the cashier");
    }


    @Override
    public void goOut() {
        System.out.println(this+" Went out from the market");
        Dispatcher.deleteBuyer();
    }


    @Override
    public String toString() {
        if(this.pensioneer)
            return this.getName()+" pensioneer";
        else return this.getName();
    }

    @Override
    public void takeBasket() {
        if(pensioneer) Util.sleep(Util.random(150,300));
        Util.sleep(Util.random(100,200));
        System.out.println(this+" Took a basket");
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
            String chosenGood = listOfKeys.remove(indexRandom);
            Double prise = listOfGoods.get(chosenGood);
            this.basket.put(chosenGood,prise);
            System.out.println(this+" put to the basket: "+chosenGood+" "+prise);
        }
    }
}