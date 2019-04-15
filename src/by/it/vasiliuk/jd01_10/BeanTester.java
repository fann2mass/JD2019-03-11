package by.it.vasiliuk.jd01_10;

import java.lang.reflect.Method;

class BeanTester {

    public static void main(String[] args) throws Exception{
        Class<Bean> object = Bean.class;
        Method[] methods = object.getMethods();
        for (Method method : methods)
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                int al = annotation.a();
                int bt = annotation.b();
                Object ob = object.newInstance();
                Object invoke = method.invoke(ob, al, bt);
                System.out.println(method.getName() + invoke);
            }


    }
}
