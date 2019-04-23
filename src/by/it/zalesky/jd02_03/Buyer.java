package by.it.zalesky.jd02_03;


class Buyer extends Thread implements IBuyer {


    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        addToQueue();
        goOut();
    }

    Object  getMonitor(){
        return  this;
    }


    Buyer(int number){
        super("Покупатель № " + number);
        Dispatcher.newBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" вошел в магазин");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" начал выбирать продукты");
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this+" закончил выбирать продукты");
    }

    @Override
    public void addToQueue() {
        System.out.println(this + " добавлен в очередь и ждет");
        QueueBuyers.add(this);
        synchronized (this){
            try {
                wait();
            }catch (InterruptedException e){
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(this + " закончил обслуживаться у кассира");
    }

    @Override
    public void goOut() {
        System.out.println(this+ " вышел из магазина");
        Dispatcher.deleteBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
