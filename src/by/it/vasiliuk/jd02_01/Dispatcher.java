package by.it.vasiliuk.jd02_01;

        import java.util.HashMap;


class Dispatcher {

    final static int kSpeed=100;
    final static int finishTime=60;

    private static HashMap<String,Double> listOfGoods = new HashMap<String,Double>(){{
        put("Onion", 3.99);
        put("Crisps", 7.99);
        put("Garlic", 3.49);
        put("Cheese", 9.99);
        put("Cake", 2.99);
        put("Chicken", 4.49);
        put("Jelly", 2.99);
        put("Water", 14.49);
        put("Soda", 6.49);

    }};

    static HashMap<String, Double> getListOfGoods() {
        return listOfGoods;
    }

}