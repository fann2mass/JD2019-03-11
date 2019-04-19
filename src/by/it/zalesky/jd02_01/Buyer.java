package by.it.zalesky.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBucket{

    @Override
    public void takeBacket() {

        System.out.println(this+" взял корзину");

    }

    @Override
    public void putGoodsToBacket() {

        System.out.println(this+" положил выбранный товар в корзину");

    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    Buyer(int number){
        super("Buyer № " + number);
    }

    @Override
    public void enterToMarket() {

        System.out.println(this+" вошел в магазин");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" начал выбирать продукты");
        int timeout = Util.random(500, 2000);
        Util.random(timeout);
        System.out.println(this+" закончил выбирать продукты");
    }

    @Override
    public void goOut() {
        System.out.println(this+ " вышел из магазина");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
