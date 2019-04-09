package by.it.khlystunova.jd01_10;

import java.lang.reflect.Method;

/*TaskC1. Создайтекласс BeanTester который в методе main с
сигнатурой, допускающей Exception:public static void main(String[] args)
 throws Exception создает экземпляр класса Bean (оператор new Bean( )
 для этого использовать нельзя!), а затем находит и запускает его методы,
 помеченные созданной аннотацией с указанными в ней параметрами a и b.
После каждого вызова invoke на консоль выводится имя найденного метода и результат запуска.*/
class BeanTester {

    public static void main(String[] args) throws Exception{
     Class<Bean> object = Bean.class;//объект представляющий класс
        Method[] methods = object.getMethods();
        for (Method method : methods)
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                int a = annotation.a();
                int b = annotation.b();
                Object o = object.newInstance();
                Object invoke = method.invoke(o, a, b);
                System.out.println(method.getName() + invoke);
            }


    }
}
