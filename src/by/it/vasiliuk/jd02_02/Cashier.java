package by.it.vasiliuk.jd02_02;

import java.util.Map;
import java.util.Set;
@SuppressWarnings("all")
class Cashier implements Runnable {

    private int number;

    Cashier(int number){
        this.number =  number ;
        Dispatcher.newCashier();
    }
    @Override
    public void run() {
        while (Dispatcher.marketOpened()) {
            Buyer buyer;
            if (QueuePensionners.getSize() > 0) {
                buyer = QueuePensionners.extract();
            } else {
                buyer = QueueBuyers.extract();
            }
            if (buyer != null) {
                service(buyer);
            }
        }
        System.out.println(this + " closed");
        Dispatcher.deleteCashier();

    }

    private void service(Buyer buyer) {
        double totalPrise = 0;
        StringBuilder check = new StringBuilder();
        check.append(this + "Started service sequence" + buyer+"\n ");
        int timeOut = Util.random(2000, 5000);
        Util.sleep(timeOut);
        Set<Map.Entry<String, Double>> goods = buyer.basket.entrySet();
        for (Map.Entry<String, Double> next : goods) {
            Double value = next.getValue();
            String good = next.getKey();
            check.append(buyer + " Buy: " + good + " " + value + "\n ");
            totalPrise += value;
        }
        check.append(this + "Finished service sequence" + buyer + "\n ");
        check.append("Price:  "+ totalPrise+"\n");
        printCheck(check);

        synchronized (buyer.getMonitor()) {
            buyer.getMonitor().notify();
        }
    }

    private void printCheck(StringBuilder check) {
        System.out.println(check);
    }

    @Override
    public String toString() {
        return "===== Cashier #" + number;
    }
}