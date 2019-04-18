package by.it.narushevich.jd02_02;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Buyer extends Thread implements IBuyer, IUseBacket {

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBasket();
        addToQueue();
        goOut();
    }

    Object getMonitor() {
        return this;
    }

    Buyer(int number) {
        super("Buyer №" + number);
        if (number % 4 == 0) pensioneer = true;
        Dispatcher.newBuyer();
    }

    static boolean pensioneer = false;

    @Override
    public void enterToMarket() {
        System.out.println(this + " came to the market");

    }

    @Override
    public void takeBacket() {
        int timeout = Util.random(100, 200);
        if (pensioneer) {
            int newTimeOut = (timeout * 3) / 2;
            Util.sleep(newTimeOut);
        } else Util.sleep(timeout);
        System.out.println(this + " take basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start to choose goods");
        int timeout = Util.random(500, 2000);
        if (pensioneer) {
            int newTimeOut = (timeout * 3) / 2;
            Util.sleep(newTimeOut);
        } else Util.sleep(timeout);
        System.out.println(this + " finish to choose goods");
    }

    @Override
    public void addToQueue() {
        System.out.println(this + " added to queue and wait");
        QueueBuyers.add(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(this + " complete service at cashier");
    }

    @Override
    public void putGoodsToBasket() {
        int timeout = Util.random(100, 200);
        if (pensioneer) {
            int newTimeOut = (timeout * 3) / 2;
            putGoods();
            Util.sleep(newTimeOut);
        } else {
            putGoods();
            Util.sleep(timeout);
        }
    }

    static String getPath() {
        String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathPack = Cashier.class.getPackage().getName().replace(".", File.separator) + File.separator;
        return userDir + pathPack + "buyers.txt";
    }

    private final File buyers = new File(getPath());

    private void writeToFile(File f, String string) {
        synchronized (buyers) {
            try (FileWriter fw = new FileWriter(f, true)) {
                fw.write(string);
                fw.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void putGoods() {
        int numberOfGoods = Util.random(1, 4);
        List<String> keysList = new ArrayList<>(Dispatcher.listOfGoods.keySet());
        StringBuilder list = new StringBuilder();
        for (int i = 1; i < numberOfGoods + 1; i++) {
            Collections.shuffle(keysList);
            String randomKey = keysList.get(new Random().nextInt(keysList.size()));
            Double price = Dispatcher.listOfGoods.get(randomKey);
            keysList.remove(randomKey);
            list.append(randomKey).append("=").append(price);
            if (i == numberOfGoods) list.append(".");
            else list.append(", ");
        }
        System.out.printf("%s put goods: %s%n", this, list);
        writeToFile(buyers, this.toString() + " bought: " + list.toString() + System.lineSeparator());
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from the market");
        Dispatcher.deleteBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
