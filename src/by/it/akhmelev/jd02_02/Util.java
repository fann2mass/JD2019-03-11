package by.it.akhmelev.jd02_02;

import java.util.Random;

class Util {

    private static Random random=new Random();

    private Util() {
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    static int random(int start, int stop){
        return start+random.nextInt(stop-start+1);
    }

    static int random(int range){
        return random(0,range);
    }
}
