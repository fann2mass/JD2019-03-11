package by.it.narushevich.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calc() throws CalcException {
        Parser parser = new Parser();
        Var var =parser.calc("2+2*2");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected,actual,1e-6);
    }
}