package by.it.vasiliuk.jd02_03;

import java.util.Map;
import java.util.Set;
@SuppressWarnings("all")
class Cashier implements Runnable {

    private int number;

    Cashier(){
        this.number = Dispatcher.cashiersCounter.incrementAndGet();
    }
    @Override
    public void run() {
        synchronized (System.out) {
            System.out.println(this + " Opened");
            System.out.println("Queue  is: " + QueueBuyers.getBuyers().size());
        }
        while (QueueBuyers.needService()) {
            Buyer buyer = null;
            if (QueueBuyers.getBuyers().size() > 0)
                buyer = QueueBuyers.extract();
            if (buyer != null) {
                service(buyer);
            }
        }
        System.out.println(this + " closed");
        Dispatcher.cashiersCounter.decrementAndGet();
    }

    private void service(Buyer buyer) {
        double totalPrise = 0;
        StringBuilder check = new StringBuilder();
        check.append("====================\n");
        check.append(this + " started service " + buyer+"\n ");
        int timeOut = Util.random(2000, 5000);
        Util.sleep(timeOut);
        Set<Map.Entry<String, Double>> goods = buyer.basket.entrySet();
        for (Map.Entry<String, Double> next : goods) {
            Double value = next.getValue();
            String good = next.getKey();
            check.append(buyer + " buy: " + good + " " + value + "\n ");
            totalPrise += value;
        }
        Dispatcher.SUM += totalPrise;
        check.append(this + " finished service " + buyer + "\n ");
        check.append("====================\n");
        check.append(" total price:  "+ totalPrise+"\n");
        check.append("Queue is: "+QueueBuyers.getBuyers().size());
        printCheack(check);

        synchronized (buyer.getMonitor()) {
            buyer.setWait(false);
            buyer.getMonitor().notify();
        }
        if(!(QueueBuyers.needService()))
            Util.sleep(500);
    }

    private void printCheack(StringBuilder check) {
        System.out.println(check);
    }

    @Override
    public String toString() {
        return "===== Cashier #" + number;
    }
}
