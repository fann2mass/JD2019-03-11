package by.it.akhmelev.jd01_10;

public class Bean {

    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 20, b = 50)
    double max(int aaaa, int bbbb) {
        return aaaa > bbbb ? aaaa : bbbb;
    }

    @Param(a = 22, b = 55)
    static double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 2, b = 5)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
