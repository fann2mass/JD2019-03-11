package by.it.akhmelev.jd02_02;

interface IBuyer {
    void enterToMarket();    //вошел в магазин (мгновенно)

    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)

    void addToQueue();       //отправился в очередь

    void goOut();            //отправился на выход(мгновенно)
}
