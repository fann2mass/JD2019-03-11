package by.it.narushevich.jd02_02;

import java.io.*;

class Cashier implements Runnable {

    private int number;

    public Cashier(int number) {
        this.number = number;
    }

    private double sum = 0;

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getSum() {
        return sum;
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

                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getPath()))) {
                        while (bufferedReader.ready()) {
                            setSum(getCheck(bufferedReader));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Util.sleep(timeout);
                    System.out.printf("Total price is: %5.2f%n", getSum());
                    System.out.println(this + " finished service " + buyer);
                    System.out.println("=================================");
                }
                synchronized (buyer.getMonitor()) {
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
