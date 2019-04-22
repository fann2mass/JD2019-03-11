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

    @Test
    public void ScalarAdd() throws Exception {
        Var var = parser.calc("2+2");
        double expected = 4.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("ScalarAdd OK");
    }

    @Test
    public void ScalarSub() throws Exception {
        Var var = parser.calc("8-2");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("ScalarSub OK");
    }

    @Test
    public void ScalarMull() throws Exception {
        Var var = parser.calc("8*8");
        double expected = 64.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("ScalarMull OK");
    }

    @Test
    public void ScalarDiv() throws Exception {
        Var var = parser.calc("16/2");
        double expected = 8.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("ScalarDiv OK");
    }

    @Test
    public void VectorMulVector() throws Exception {
        Var var = parser.calc("{3,4,5}*{1,2,3}");
        double expected = 26.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("VectorMulVector OK");
    }

    @Test
    public void simpleExpressionCalc() throws Exception {
        Var var = parser.calc("2+2*2");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("simpleExpressionCalc OK");
    }

    @Test
    public void createVarCalc() throws Exception {
        parser.calc("A=2+2*2");
        Var var= Var.createVar("A");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("createVarCalc OK");
    }
}