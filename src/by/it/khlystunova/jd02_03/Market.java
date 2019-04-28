package by.it.khlystunova.jd02_03;


import static by.it.khlystunova.jd02_03.Dispatcher.executorService;


class Market {



    public static void main(String[] args) {

        System.out.println("------------market is opened---------------");
        executorService.execute(new Cashier());
        int numberBuyer = 0;
        int time = 0;

        while (!Dispatcher.planComplete()) {
            if (time < 30) {
                int count = Util.random();
                if (!(Dispatcher.getBuyerInMarket() >= time + 10)) {
                    for (int n = 0; n < count; n++) {
                        if (!Dispatcher.planComplete()) {
                            Buyer buyer = new Buyer(++numberBuyer);
                            buyer.start();

                        }
                    }
                }
                time++;

            } else  {
                int count = Util.random();
                if (Dispatcher.getBuyerInMarket() <= 40 + (30 - time)) {
                    for (int n = 0; n < count; n++) {
                        if (!Dispatcher.planComplete()) {
                            Buyer buyer = new Buyer(++numberBuyer);
                            buyer.start();

                        }
                    }
                }
                time++;
            }
            if(time== Dispatcher.MINUTE)time=0;
            Util.sleep(1000);
        }

        Dispatcher.executorShutDown();

        System.out.printf(" TOTAL AMOUNT : %.2f \n",Dispatcher.SUM);
        System.out.println("------------market is closed-------------");
    }
}
