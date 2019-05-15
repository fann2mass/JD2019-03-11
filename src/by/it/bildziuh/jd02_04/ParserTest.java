package by.it.bildziuh.jd02_04;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private static Parser parser;

    @BeforeClass
    public static void creatParser() {
        parser = new Parser();
    }

    @Test
    public void multipleOperations() throws Exception {
        Var var = parser.calc("{3,4}+5*6-7");
        String expected = "{26.0, 27.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void createVar() throws Exception {
        parser.calc("A=2+2*2");
        Var var = Var.createVar("A");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void scalarAddScalar() throws Exception {
        Var var = parser.calc("1+2");
        double expected = 3.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void vectorAddScalar() throws Exception {
        Var var = parser.calc("{1,2}+3");
        String expected = "{4.0, 5.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void matrixAddScalar() throws Exception {
        Var var = parser.calc("{{1,2},{3,4}}+5");
        String expected = "{{6.0, 7.0}, {8.0, 9.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void scalarSubScalar() throws Exception {
        Var var = parser.calc("2-1");
        double expected = 1.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void vectorSubVector() throws Exception {
        Var var = parser.calc("{3,4}-{1,2}");
        String actual = var.toString();
        String expected = "{2.0, 2.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void vectorSubScalar() throws Exception {
        Var var = parser.calc("{2,3}-1");
        String actual = var.toString();
        String expected = "{1.0, 2.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void matrixSubMatrix() throws Exception {
        Var var = parser.calc("{{2,3},{4,5}}-{{1,2},{3,4}}");
        String actual = var.toString();
        String expected = "{{1.0, 1.0}, {1.0, 1.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void scalarMulScalar() throws Exception {
        Var var = parser.calc("1*2");
        double expected = 2.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void vectorMulScalar() throws Exception {
        Var var = parser.calc("{1,2}*3");
        String actual = var.toString();
        String expected = "{3.0, 6.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void vectorMulVector() throws Exception {
        Var var = parser.calc("{1,2}*{3,4}");
        double actual = Double.parseDouble(var.toString());
        double expected = 11.0;
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void matrixMulScalar() throws Exception {
        Var var = parser.calc("{{1,2},{3,4}}*5");
        String actual = var.toString();
        String expected = "{{5.0, 10.0}, {15.0, 20.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void matrixMulVector() throws Exception {
        Var var = parser.calc("{{1,2},{3,4}}*{5,6}");
        String actual = var.toString();
        String expected = "{17.0, 39.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void matrixMulMatrix() throws Exception {
        Var var = parser.calc("{{1,2},{3,4}}*{{1,2},{3,4}}");
        String actual = var.toString();
        String expected = "{{7.0, 10.0}, {15.0, 22.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void scalarDivScalar() throws Exception {
        Var var = parser.calc("1/2");
        double expected = 0.5;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void vectorDivScalar() throws Exception {
        Var var = parser.calc("{2,4}/2");
        String actual = var.toString();
        String expected = "{1.0, 2.0}";
        assertEquals(expected, actual);
    }

}