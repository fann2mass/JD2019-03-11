package by.it.narushevich.jd02_03;

interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void addToQueue(); //покупатель пошел в очередь
    void goOut(); //отправился на выход(мгновенно)
}
