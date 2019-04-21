package by.it.eslaikouskaya.jd02_03;

import java.util.Random;

class Util {

    private static Random random=new Random();

    private Util() {
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ Dispatcher.kSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int random(int start, int stop){
        return start+random.nextInt(stop-start+1);
    }

    static int random(int range){
        return random(0,range);
    }
}
