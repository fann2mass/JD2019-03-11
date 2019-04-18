package by.it.akhmelev.jd02_02;

class Cashier implements Runnable{

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (Dispatcher.marketOpened()){
            Buyer buyer = QueueBuyers.extract();
            if (buyer!=null){
                System.out.println(this+" started service "+buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this+" finished service "+buyer);
                synchronized (buyer.getMonitor()){
                    buyer.getMonitor().notify();
                }
            }
        }
        System.out.println(this+" closed");
    }

    @Override
    public String toString() {
        return "-- Cashier №" + number;
    }
}
