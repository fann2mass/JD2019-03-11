package by.it.khlystunova.jd02_04;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParserTest {

    private static Parser parser;

    @BeforeClass
    public static void createParser(){
        parser = new Parser();
    }

    @Test
    public void simpleExpressionCalc() throws Exception{

    Var var = parser.calc("2+2*2");
    double expected = 6.0;
    double actual = Double.parseDouble(var.toString());
    Assert.assertEquals(expected,actual,1e-6);

    }
}