package by.it.zalesky.Calc;

public class Runner {

        private static void print(Var var) {
            if (var!=null)
                System.out.println(var);
        }

        public static void main(String[] args) {

            Var v1 = new Scalar(3.0);
            Var v2 = new Vector(new double[]{1, 2, 3}); // закомментируйте вектор и/или
  //        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");// матрицу, если вы их не реализовали
            /* Уровень сложности A (калькулятор) */
            print(v1.add(v1)); //выведет в консоль 6.0
            print(v1.sub(v1)); //выведет в консоль 0.0
            print(v1.mul(v1)); //выведет в консоль 9.0
            print(v1.div(v1)); //выведет в консоль 1.0
            /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        /* Уровень сложности C (матричные операции и умножение на вектор)
        закомментируйте, если не реализовали */
 //           print(m.add(v2)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
 //           print(m.sub(v2)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
 //           print(m.mul(v1)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
  //          print(m.mul(v2)); //{14.0, 32.0, 50.0}

    //        Var v1 = new Scalar(3.14);
    //        Var v2 = new Vector(new double[] {1,2,4});
    //        System.out.println(v1);System.out.println(v2);
    }
}
