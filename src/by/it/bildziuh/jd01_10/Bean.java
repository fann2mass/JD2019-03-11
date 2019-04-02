package by.it.bildziuh.jd01_10;


public class Bean {

    @Param(a = 3, b = 5)
    static double sum(int a, int b) {
        return (a + b);
    }

    @Param(a = 2, b = 4)
    double max(int a, int b) {
        if (a > b) return a;
        else return b;
    }

    @Param(a = 2, b = 4)
    double min(int a, int b) {
        if (a < b) return a;
        else return b;
    }

    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
