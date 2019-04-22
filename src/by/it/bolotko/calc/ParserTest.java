package by.it.bolotko.calc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void simpleExpressionCalc() throws Exception{
        Parser parser=new Parser();
        Var var=parser.calc("2+2*2");
        double expected=6.0;
        double actual=Double.parseDouble(var.toString());
        Assert.assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void ExpressionCalc() throws Exception{
        Parser parser=new Parser();
        Var var=parser.calc("2+2*2");
        double expected=6.0;
        double actual=Double.parseDouble(var.toString());
        Assert.assertEquals(expected, actual, 1e-6);
    }
}