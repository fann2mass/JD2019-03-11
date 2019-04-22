package by.it.narushevich.jd02_04;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private static Parser parser;

    @BeforeClass
    public static void createParser(){
        parser = new Parser();
    }

    @Test
    public void additionExpressionCalc() throws CalcException {
        Var var = parser.calc("5+2");
        double expected = 7.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void subtractionExpressionCalc() throws CalcException {
        Var var = parser.calc("6-1");
        double expected = 5.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void multiplicationExpressionCalc() throws CalcException {
        Var var = parser.calc("2*8");
        double expected = 16.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void divisionExpressionCalc() throws CalcException {
        Var var = parser.calc("2/4");
        double expected = 0.5;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void scalarExpressionCalc() throws CalcException {
        Var var = parser.calc("2+2*2/4-1");
        double expected = 2.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

    @Test

    public void createVarCalc() throws CalcException {
        parser.calc("A=3+5*2");
        Var var=Var.createVar("A");
        double expected = 13.0;
        assert var != null;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
    }

}