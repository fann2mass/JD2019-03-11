package by.it.eslaikouskaya.jd02_03;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private static Semaphore semaphore = new Semaphore(20);

    private boolean wait;
    void setWait(boolean wait) {
        this.wait = wait;
    }

    private static double proceed = 0;
    static synchronized double getAmount(){return proceed;}

    private final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(50);
    private static final AtomicInteger baskets = new AtomicInteger(0);


    Buyer(int number, String pensioner) {
        super("Buyer"+pensioner+" № "+number);
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

    Object getMonitor(){
        return this;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to the market");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" start to choose goods");
        try {
            semaphore.acquire();
            if (this.toString().contains("pensioner")){
                int timeout = Util.random(750, 3000);
                Util.sleep(timeout);
            } else {
                int timeout = Util.random(500, 2000);
                Util.sleep(timeout);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public void takeBasket() {
        try {
            if (baskets.get()>50) baskets.set(0);
            queue.put("basket "+baskets.getAndAdd(1));
            System.out.println(this + " take basket");
            if (this.toString().contains("pensioner")) {
                int timeout = Util.random(100, 200);
                Util.sleep(timeout);
            } else {
                int timeout = Util.random(150, 300);
                Util.sleep(timeout);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this+" start put goods to basket");
        if (this.toString().contains("pensioner")){
            int timeout = Util.random(100, 200);
            Util.sleep(timeout);
        } else {
            int timeout = Util.random(150, 300);
            Util.sleep(timeout);
        }
        String check = check();
	    System.out.println(check);
	    System.out.println(this+" finish put goods to basket");
    }

   public String check() {
	   Map<String, Double> products = Dispatcher.getGoods();
	   Set<String> keySets = products.keySet();
	   ArrayList<String> productNames = new ArrayList<>(keySets);
	   StringBuilder sb = new StringBuilder();

       double amount = 0;
	   int goodsInBasket = Util.random(1, 4);
	   for (int i = 0; i < goodsInBasket; i++) {
		   String productInBasket = productNames.get(Util.random
				   (0, productNames.size() - 1));
		   Double value = products.get(productInBasket);
		   amount+=value;
		   proceed+=value;

		   sb.append(this).append(" buy ").append(productInBasket).append(": ").append(value).append("\n");
	   }
	   sb.append("Total amount for ").append(this).append(" is: ").append(amount);
	   return sb.toString();
   }

    @Override
    public void addToQueue() {
        System.out.println(this + " added to queue and wait");
        QueueBuyers.add(this);
        wait = true;
        synchronized (this) {
            while (wait) try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(this + " complete service at cashier");
        try {
            System.out.println(queue.take()+" returned");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goOut() {
        System.out.println(this+" go out from the market");
        Dispatcher.deleteBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
