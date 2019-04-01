package by.it.khlystunova.jd01_10;

/*2.TaskA2.Создайте класс Bean который содержит два статическихи два нестатических метода.
Имена sum max min avg с сигнатурой (int a, int b), какие именно из них статические
выберите произвольно.Методы должны вычислять для своих параметров a и b сумму,
максимум, минимум и среднее и возвращать результат как double.
Три из этих методов должны быть помечены ранее созданной аннотацией с разными значениями a и b*/

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

