package by.it.bolotko.jd01_10;

public class Bean {

    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 8, b = 10)
    static double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 8, b = 10)
    double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 8, b = 10)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
