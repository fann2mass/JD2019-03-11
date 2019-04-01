package by.it.khlystunova.jd01_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*1.TaskA1.Создайте собственную аннотацию Param,
 которая описывает параметры для некоторой процедуры тестирования произвольного метода с
 сигнатурой (int a, int b), помеченного такой аннотацией.Пример использования:@Param(a=2, b=5)
 public double avg(int a, int b) { … }.
*/

@Retention(RetentionPolicy.RUNTIME)//используется для рефлексии - языковой инстурмент получения сведений о классе во время выполнении программы.
@Target(ElementType.METHOD)
public @interface Param {
    int a();
    int b();
}
