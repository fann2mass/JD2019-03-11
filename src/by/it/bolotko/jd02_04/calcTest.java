package by.it.bolotko.jd02_04;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calcTest {

    private static Parser parser;

    @BeforeClass
    public static void createParser(){
        parser = new Parser();
    }


    //Tests Scalar
    @Test(timeout = 5000)
    public void ScalarAdd() throws Exception {
        Var var = parser.calc("2+2");
        double expected = 4.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("2+2=4 OK");
    }

    @Test(timeout = 5000)
    public void ScalarSub() throws Exception {
        Var var = parser.calc("8-2");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("8-2=6 OK");
    }

    @Test(timeout = 5000)
    public void ScalarMull() throws Exception {
        Var var = parser.calc("8*8");
        double expected = 64.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("8*8=64 OK");
    }

    @Test(timeout = 5000)
    public void ScalarDiv() throws Exception {
        Var var = parser.calc("16/2");
        double expected = 8.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("16/2=8 OK");
    }



    //Tests Vector
    @Test(timeout = 5000)
    public void VectorAddScalar() throws Exception {
        Var var = parser.calc("{4,5,6}+5");
        String expected = "{9.0, 10.0, 11.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{4,5,6}+5={9.0, 10.0, 11.0} OK");
    }

    @Test(timeout = 5000)
    public void VectorAddVector() throws Exception {
        Var var = parser.calc("{4,5,6}+{1,2,3}");
        String expected = "{5.0, 7.0, 9.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{4,5,6}+{1,2,3}={5.0, 7.0, 9.0} OK");
    }

    @Test(timeout = 5000)
    public void VectorSubScalar() throws Exception {
        Var var = parser.calc("{4,5,6}-5");
        String expected = "{-1.0, 0.0, 1.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{4,5,6}-5={-1.0, 0.0, 1.0} OK");
    }

    @Test(timeout = 5000)
    public void VectorSubVector() throws Exception {
        Var var = parser.calc("{4,5,6}-{1,2,3}");
        String expected = "{3.0, 3.0, 3.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{4,5,6}-{1,2,3}={3.0, 3.0, 3.0} OK");
    }

    @Test(timeout = 5000)
    public void VectorMulScalar() throws Exception {
        Var var = parser.calc("{3,4,5}*2");
        String expected = "{6.0, 8.0, 10.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{3,4,5}*2={26.0, 8.0, 10.0} OK");
    }

    @Test(timeout = 5000)
    public void VectorMulVector() throws Exception {
        Var var = parser.calc("{3,4,5}*{1,2,3}");
        double expected = 26.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("{3,4,5}*{1,2,3}=26 OK");
    }

    @Test(timeout = 5000)
    public void VectorDivScalar() throws Exception {
        Var var = parser.calc("{4,5,6}/2");
        String expected = "{2.0, 2.5, 3.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{4,5,6}/2={2.0, 2.5, 3.0} OK");
    }



    //Tests Expression
    @Test(timeout = 5000)
    public void longExpressionCalc() throws Exception {
        Var var = parser.calc("2+2*2");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("2+2*2=6 OK");
    }

    @Test(timeout = 5000)
    public void createVarCalc() throws Exception {
        parser.calc("A=2+2*2");
        Var var= Var.createVar("A");
        double expected = 6.0;
        assert var != null;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("A=2+2*2, A=6  OK");
    }
}