package by.it.narushevich.jd02_03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

class Cashier implements Runnable {

    private int number;

    public Cashier(int number) {
        this.number = number;
    }

     @Override
    public void run() {
        while (Dispatcher.marketOpened()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                synchronized (System.out) {
                    System.out.println("=================================");
                    System.out.println(this + " started service " + buyer);
                    int timeout = Util.random(2000, 5000);
                    Util.sleep(timeout);
                    System.out.println(this + " finished service " + buyer);
                    System.out.println("=================================");
                }
                synchronized (buyer.getMonitor()) {
                    buyer.setWait(false);
                    buyer.getMonitor().notify();
                }
            }
        }
        System.out.println(this + " is closed");
    }

    private double getCheck(BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();
        double sum = 0;
        if (line.contains(this.toString())) {
            String[] split1 = line.split(": ");
            for (int i = 0; i < split1.length; i++) {
                String[] split2 = split1[1].split(",");
                for (String good : split2) {
                    String price = good.replaceFirst("[a-zA-Z-\\s=]+", "");
                    double money = Double.parseDouble(price);
                    sum = 0;
                    sum += money;
                }
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Cashier №" + number;
    }

    private static String getPath() {
        String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathPack = Cashier.class.getPackage().getName().replace(".", File.separator) + File.separator;
        return userDir + pathPack + "buyers.txt";
    }
}
