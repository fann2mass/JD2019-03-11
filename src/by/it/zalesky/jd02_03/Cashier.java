package by.it.zalesky.jd02_03;

class Cashier implements Runnable{

    private int number;

    Cashier(int number){
        this.number = number;
    }

    @Override
    public void run() {
        while (Dispatcher.marketOpened()){
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " начало обслуживания " + buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this + " конец обслуживания " + buyer);
                synchronized (buyer.getMonitor()){
                    buyer.getMonitor().notify();
                }
            }
        }

        System.out.println(this + " закрылся");
    }

    @Override
    public String toString() {
        return "-- Кассир №" +  number;

    }
}
