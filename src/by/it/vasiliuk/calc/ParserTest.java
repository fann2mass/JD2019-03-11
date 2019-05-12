package by.it.vasiliuk.calc;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    private static Parser parser;

    @BeforeClass
    public static void createParser(){
        parser = new Parser();
    }

    //Scalar calculations
    @Test
    public void scalarAddScalar() throws Exception {
        Var var = parser.calc("2+2");
        double expected = 4.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);//expected?=actual
    }

    @Test
    public void scalarSubScalar() throws Exception {
        Var var = parser.calc("2-2");
        double expected = 0.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);//expected?=actual
    }
    @Test
    public void scalarMulScalar() throws Exception {
        Var var = parser.calc("2*2");
        double expected = 4.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);//expected?=actual
    }
    @Test
    public void scalarDivScalar() throws Exception {
        Var var = parser.calc("2/2");
        double expected = 1.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);//expected?=actual
    }
    @Test
    public void scalarExpressionCalc() throws Exception {
        Var var = parser.calc("2+2*2/2-2");
        double expected = 2.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);//expected?=actual
    }

    @Test
    public void createVarFromScalarCalc() throws Exception {
        parser.calc("A=2+2*2");
        Var var=Var.createVar("A");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    //проверяем вычисления с векторами
    @Test
    public void vectorAddVector() throws Exception {
        Var var = parser.calc("{2,2}+{2,2}");
        String actual = var.toString();
        String expected = "{4.0, 4.0}";
        assertEquals(expected, actual);//expected?=actual
    }
    @Test
    public void vectorAddScalar() throws Exception {
        Var var = parser.calc("{2,2}+2");
        String actual = var.toString();
        String expected = "{4.0, 4.0}";
        assertEquals(expected, actual);//expected?=actual
    }
    @Test
    public void vectorSubVector() throws Exception {
        Var var = parser.calc("{2,2}-{2,2}");
        String actual = var.toString();
        String expected = "{0.0, 0.0}";
        assertEquals(expected, actual);//expected?=actual
    }
    @Test
    public void vectorSubScalar() throws Exception {
        Var var = parser.calc("{2,2}-2");
        String actual = var.toString();
        String expected = "{0.0, 0.0}";
        assertEquals(expected, actual);//expected?=actual
    }
    @Test
    public void vectorMulVector() throws Exception {
        Var var = parser.calc("{2,2}*{2,2}");
        double actual = Double.parseDouble(var.toString());
        double expected =8.0;
        assertEquals(expected, actual,1e-6);//expected?=actual
    }
    @Test
    public void vectorMulScalar() throws Exception {
        Var var = parser.calc("{2,2}*2");
        String actual = var.toString();
        String expected = "{4.0, 4.0}";
        assertEquals(expected, actual);//expected?=actual
    }
    @Test
    public void vectorDivScalar() throws Exception {
        Var var = parser.calc("{2,2}/2");
        String actual = var.toString();
        String expected = "{1.0, 1.0}";
        assertEquals(expected, actual);//expected?=actual
    }

    @Test
    public void vectorExpressionCalc() throws Exception {
        Var var = parser.calc("{2,2}+{2,2}-{1,1}*2/4");
        String actual = var.toString();
        String expected = "{3.5, 3.5}";
        assertEquals(expected, actual);//expected?=actual
    }
    @Test
    public void createVarFromVectorCalc() throws Exception {
        parser.calc("A={2,2}*{2,2}");
        Var var=Var.createVar("A");
        double expected = 8.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    //проверяем вычисления с матрицами
    @Test
    public void matrixAddMatrix() throws Exception {
        Var var = parser.calc("{{2,2},{2,2}}+{{3,3},{3,3}}");
        String actual = var.toString();
        String expected = "{{5.0, 5.0}, {5.0, 5.0}}";
        assertEquals(expected, actual);//expected?=actual
    }

    @Test
    public void matrixAddScalar() throws Exception {
        Var var = parser.calc("{{2,2},{2,2}}+2");
        String actual = var.toString();
        String expected = "{{4.0, 4.0}, {4.0, 4.0}}";
        assertEquals(expected, actual);//expected?=actual
    }

    @Test
    public void matrixSubMatrix() throws Exception {
        Var var = parser.calc("{{2,2},{2,2}}-{{3,3},{3,3}}");
        String actual = var.toString();
        String expected = "{{-1.0, -1.0}, {-1.0, -1.0}}";
        assertEquals(expected, actual);//expected?=actual
    }

    @Test
    public void matrixMulScalar() throws Exception {
        Var var = parser.calc("{{2,2},{2,2}}*3");
        String actual = var.toString();
        String expected = "{{6.0, 6.0}, {6.0, 6.0}}";
        assertEquals(expected, actual);//expected?=actual
    }

    @Test
    public void matrixMulVector() throws Exception {
        Var var = parser.calc("{{6.0, 6.0}, {6.0, 6.0}}*{2,2}");
        String actual = var.toString();
        String expected = "{24.0, 24.0}";
        assertEquals(expected, actual);//expected?=actual
    }
    @Test
    public void matrixMulMatrix() throws Exception {
        Var var = parser.calc("{{2,2},{2,2}}*{{2,2},{2,2}}");
        String actual = var.toString();
        String expected = "{{8.0, 8.0}, {8.0, 8.0}}";
        assertEquals(expected, actual);//expected?=actual
    }

    @Test
    public void matrixExpressionCalc() throws Exception {
        Var var = parser.calc("{{2,2},{2,2}}+{{3,3},{3,3}}*2");
        String actual = var.toString();
        String expected = "{{8.0, 8.0}, {8.0, 8.0}}";
        assertEquals(expected, actual);//expected?=actual
    }
    @Test
    public void createVarFromMatrixCalc() throws Exception {
        parser.calc("A={{2,2},{2,2}}*{{2,2},{2,2}}");
        String actual = Var.createVar("A").toString();
        String expected = "{{8.0, 8.0}, {8.0, 8.0}}";
        assertEquals(expected, actual);
    }


}