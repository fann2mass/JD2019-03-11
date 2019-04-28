package by.it.bolotko.jd02_06.calc;

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
//*********************************************************************************************************************


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
//*********************************************************************************************************************


    //Tests Matrix
    @Test(timeout = 5000)
    public void MatrixAddScalar() throws Exception {
        Var var = parser.calc("{{2,3},{4,5}}+4");
        String expected = "{{6.0, 7.0}, {8.0, 9.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{{2,3},{4,5}}+4={{6.0, 7.0}, {8.0, 9.0}} OK");
    }

    @Test(timeout = 5000)
    public void MatrixAddMatrix() throws Exception {
        Var var = parser.calc("{{2,3},{4,5}}+{{6,7},{8,9}}");
        String expected = "{{8.0, 10.0}, {12.0, 14.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{{2,3},{4,5}}+{{6,7},{8,9}}={{8.0, 10.0}, {12.0, 14.0}} OK");
    }

    @Test(timeout = 5000)
    public void MatrixSubScalar() throws Exception {
        Var var = parser.calc("{{2,3},{4,5}}-4");
        String expected = "{{-2.0, -1.0}, {0.0, 1.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{{2,3},{4,5}}-4={{-2.0, -1.0}, {0.0, 1.0}} OK");
    }

    @Test(timeout = 5000)
    public void MatrixSubMatrix() throws Exception {
        Var var = parser.calc("{{2,3},{4,5}}-{{6,7},{8,9}}");
        String expected = "{{-4.0, -4.0}, {-4.0, -4.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{{2,3},{4,5}}-{{6,7},{8,9}}={{-4.0, -4.0}, {-4.0, -4.0}} OK");
    }

    @Test(timeout = 5000)
    public void MatrixMulScalar() throws Exception {
        Var var = parser.calc("{{2,3},{4,5}}*4");
        String expected = "{{8.0, 12.0}, {16.0, 20.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{{2,3},{4,5}}*4={{8.0, 12.0}, {16.0, 20.0}} OK");
    }

    @Test(timeout = 5000)
    public void MatrixMulMatrix() throws Exception {
        Var var = parser.calc("{{2,3},{4,5}}*{{6,7},{8,9}}");
        String expected = "{{36.0, 41.0}, {64.0, 73.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{{2,3},{4,5}}*{{6,7},{8,9}}={{36.0, 41.0}, {64.0, 73.0}} OK");
    }
//*********************************************************************************************************************



    //Tests Expression
    @Test(timeout = 5000)
    public void longExpressionScalarCalc() throws Exception {
        Var var = parser.calc("2+2*2");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("2+2*2=6 OK");
    }

    @Test(timeout = 5000)
    public void longCreateVarScalarCalc() throws Exception {
        parser.calc("A=2+2*2");
        Var var= Var.createVar("A");
        double expected = 6.0;
        assert var != null;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("A=2+2*2=6  OK");
    }

    @Test(timeout = 5000)
    public void longExpressionVectorCalc() throws Exception {
        Var var = parser.calc("{2,3,4}*{3,4,5}+{7,6,5}-{2,1,3}");
        String expected = "{43.0, 43.0, 40.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{2,3,4}*{3,4,5}+{7,6,5}-{2,1,3}={43.0, 43.0, 40.0} OK");
    }

    @Test(timeout = 5000)
    public void longCreateVarVectorCalc() throws Exception {
        parser.calc("A={2,3,4}*{3,4,5}+{7,6,5}-{2,1,3}");
        Var var= Var.createVar("A");
        String expected = "{43.0, 43.0, 40.0}";
        assert var != null;
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("A={2,3,4}*{3,4,5}+{7,6,5}-{2,1,3}={43.0, 43.0, 40.0} OK");
    }

    @Test(timeout = 5000)
    public void longExpressionMatrixCalc() throws Exception {
        Var var = parser.calc("{{2,3},{4,5}}+{{5,4},{6,7}}*{{3,2},{2,2}}");
        String expected = "{{25.0, 21.0}, {36.0, 31.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("{{2,3},{4,5}}+{{5,4},{6,7}}*{{3,2},{2,2}}={{25.0, 21.0}, {36.0, 31.0}} OK");
    }

    @Test(timeout = 5000)
    public void longCreateVarMatrixCalc() throws Exception {
        parser.calc("A={{2,3},{4,5}}+{{5,4},{6,7}}*{{3,2},{2,2}}");
        Var var= Var.createVar("A");
        String expected = "{{25.0, 21.0}, {36.0, 31.0}}";
        assert var != null;
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("A={{2,3},{4,5}}+{{5,4},{6,7}}*{{3,2},{2,2}}={{25.0, 21.0}, {36.0, 31.0}} OK");
    }
}