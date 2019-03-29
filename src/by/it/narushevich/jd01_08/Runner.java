package by.it.narushevich.jd01_08;

public class Runner {
    private static void print(Var var) {
        if (var!=null)
            System.out.println(var);
    }

    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var v = new Vector(new double[]{1, 2, 3});
        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");
        Var m1 = new Matrix("{{1, 2},{3, 4}}");
        Var m2 = new Matrix("{{4, 5},{7, 8}}");
        /* Уровень сложности A (калькулятор) */
        System.out.println("Сложение 2-х скаляров: ");
        print(s.add(s)); //выведет в консоль 6.0
        System.out.println("Вычитание 2-х скаляров: ");
        print(s.sub(s)); //выведет в консоль 0.0
        System.out.println("Произведение 2-х скаляров: ");
        print(s.mul(s)); //выведет в консоль 9.0
        System.out.println("Деление 2-х скаляров: ");
        print(s.div(s)); //выведет в консоль 1.0
        /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        System.out.println("Сложение 2-х векторов: ");
        print(v.add(v)); //выведет в консоль {2.0, 4.0, 6.0}
        System.out.println("Вычитание 2-х векторов: ");
        print(v.sub(v)); //выведет в консоль {0.0, 0.0, 0.0}
        System.out.println("Произведение 2-х векторов: ");
        print(v.mul(v)); //выведет в консоль 14.0
        System.out.println("Деление 2-х векторов: ");
        print(v.div(v)); //сообщит о невозможности операции

        /* Уровень сложности C (матричные операции и умножение на вектор)
        закомментируйте, если не реализовали */
        System.out.println("Сложение матрицы и скаляра: ");
        print(m1.add(s)); //
        System.out.println("Сложение матрицы и вектора: ");
        print(m.add(v)); // Сложение невозможно
        System.out.println("Сложение 2-х матриц: ");
        print(m1.add(m2)); //{{5.0, 7.0}, {10.0, 12.0}}
        System.out.println("Вычитание 2-х матриц: ");
        print(m.sub(m)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
        System.out.println("Умножение 2-х матриц: ");
        print(m1.mul(m2)); //{{18.0, 21.0}, {40.0, 47.0}}
        System.out.println("Умножение матрицы на вектор: ");
        print(m.mul(v)); //{14.0, 32.0, 50.0}
    }
}