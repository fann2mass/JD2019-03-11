package by.it.akhmelev.jd02_01;

class Buyer extends Thread implements IBuyer {

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    Buyer(int number) {
        super("Buyer № "+number);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" start to choose goods");
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this+" finish to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this+" go out from the market");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
