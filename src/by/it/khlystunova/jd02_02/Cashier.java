package by.it.khlystunova.jd02_02;

public class Cashier implements Runnable {

    private int number;

    public Cashier(int number){
       this.number =  number ;
    }
    @Override
    public String toString() {
        return "Cashier №" + number;
    }

    @Override
    public void run() {
       while(Dispatcher.marketOpened()){
           Buyer buyer = QueueBuyers.extract();
           if(buyer!=null){
               System.out.println(this+" started service" +buyer);
               int timeout = Util.random(2_000,5_000);
               Util.sleep(timeout);
               System.out.println(this+" finished service" +buyer);
               synchronized (buyer){
                   notify();
               }
           }
       }
        System.out.println(this+" closed");
    }
}
