package by.it.bildziuh.jd02_01;

class Util {
    static void sleep(long timeout){
        try {
            Thread.sleep(timeout/Dispatcher.kSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int random(int start, int stop){
        return (int)(Math.random()*(stop-start+1))+start;
    }

    static int random(int range){
        return random(0,range);
    }
}
