package by.it.narushevich.jd02_01;

class Util {
    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int random(int start, int stop) {
        return (int) (Math.random()*(stop-start+1))+start;
    }
    static int random(int range){
        return random(0, range);
    }
}

