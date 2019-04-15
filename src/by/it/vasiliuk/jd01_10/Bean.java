package by.it.vasiliuk.jd01_10;

public class Bean {
    @Param( a = 5, b = 3)
    public static double sum(int a, int b){
        return a+b;
    }
    @Param( a = 6, b = 43)
    public static double max(int a, int b){
        return a>b?a:b;
    }
    @Param( a = 4, b = 33)
    public double min(int a, int b){
        return a<b?a:b;
    }
    public double avg(int a, int b){
        return (a + b) / 2.0;
    }
}

