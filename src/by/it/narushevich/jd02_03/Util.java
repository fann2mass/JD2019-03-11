package by.it.narushevich.jd02_03;

import java.util.Random;

class Util {

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int random(int start, int stop) {
        return new Random().nextInt(stop-start)+1;
    }
    static int random(int range){
        return new Random().nextInt(range);
    }
}

