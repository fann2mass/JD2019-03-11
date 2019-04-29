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

    @Test (timeout = 30)
    public void additionScalarCalc() throws CalcException {
        Var var = parser.calc("5+2");
        double expected = 7.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("Тест на сложение двух скаляров пройден");
    }

    @Test (timeout = 100)
    public void subtractionScalarCalc() throws CalcException {
        Var var = parser.calc("6-1");
        double expected = 5.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("Тест на вычитание двух скаляров пройден");
    }

    @Test (timeout = 100)
    public void multiplicationScalarCalc() throws CalcException {
        Var var = parser.calc("2*8");
        double expected = 16.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("Тест на умножение двух скаляров пройден");
    }

    @Test (timeout = 30)
    public void divisionScalarCalc() throws CalcException {
        Var var = parser.calc("2/4");
        double expected = 0.5;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("Тест на деление двух скаляров пройден");
    }

    @Test (timeout = 100)
    public void additionVectorScalarCalc() throws CalcException {
        Var var = parser.calc("{2,5}+2");
        String expected = "{4.0, 7.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на сложение вектора и скаляра пройден");
    }

    @Test (timeout = 100)
    public void additionVectorCalc() throws CalcException {
        Var var = parser.calc("{2,5}+{2,6}");
        String expected = "{4.0, 11.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на сложение двух векторов пройден");
    }

    @Test (timeout = 100)
    public void subtractionVectorScalarCalc() throws CalcException {
        Var var = parser.calc("{6,1}-2");
        String expected = "{4.0, 1.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на вычитание скаляра из вектора пройден");
    }

    @Test (timeout = 100)
    public void subtractionVectorCalc() throws CalcException {
        Var var = parser.calc("{6,1}-{2,1}");
        String expected = "{4.0, 0.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на вычитание вектора из другого вектора пройден");
    }

    @Test (timeout = 100)
    public void multiplicationVectorScalarCalc() throws CalcException {
        Var var = parser.calc("{2,8}*4");
        String expected = "{8.0, 32.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на умножение вектора и скаляра пройден");
    }
    @Test (timeout = 100)
    public void multiplicationVectorCalc() throws CalcException {
        Var var = parser.calc("{2,8}*{4,3}");
        double expected = 32.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("Тест на произведение двух векторов пройден");
    }

    @Test (timeout = 50)
    public void divisionVectorScalarCalc() throws CalcException {
        Var var = parser.calc("{2,4}/2");
        String expected = "{1.0, 2.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на деление вектора на скаляр пройден");
    }

    @Test (timeout = 100)
    public void scalarExpressionCalc() throws CalcException {
        Var var = parser.calc("2+2*2/4-1");
        double expected = 2.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("Тест на скалярные операции пройден");
    }

    @Test (timeout = 100)
    public void additionMatrixScalarCalc() throws CalcException {
        Var var = parser.calc("{{2,3},{4,5}}+4");
        String expected = "{{6.0, 7.0}, {8.0, 9.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на сложение матрицы и скаляра пройден");
    }

    @Test (timeout = 100)
    public void additionMatrixCalc() throws CalcException {
        Var var = parser.calc("{{2,3},{4,5}}+{{3,4},{5,6}}");
        String expected = "{{5.0, 7.0}, {9.0, 11.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на сложение двух матриц пройден");
    }

    @Test (timeout = 100)
    public void subtractionMatrixScalarCalc() throws CalcException {
        Var var = parser.calc("{{2,3},{4,5}}-4");
        String expected = "{{-2.0, -1.0}, {0.0, 1.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на вычитание скаляра из матрицы пройден");
    }

    @Test (timeout = 100)
    public void subtractionMatrixCalc() throws CalcException {
        Var var = parser.calc("{{2,3},{4,5}}-{{3,4},{5,6}}");
        String expected = "{{-1.0, -1.0}, {-1.0, -1.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на вычитание двух матриц пройден");
    }

    @Test (timeout = 100)
    public void multiplicationMatrixScalarCalc() throws CalcException {
        Var var = parser.calc("{{2,3},{4,5}}*3");
        String expected = "{{6.0, 9.0}, {12.0, 15.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на произведение матрицы и скаляра пройден");
    }

    @Test (timeout = 100)
    public void multiplicationMatrixVectorCalc() throws CalcException {
        Var var = parser.calc("{{6,9},{12,15}}*{2,8}");
        String expected = "{84.0, 144.0}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на произведение матрицы и вектора пройден");
    }
    @Test (timeout = 100)
    public void multiplicationMatrixCalc() throws CalcException {
        Var var = parser.calc("{{2,3},{4,5}}*{{3,4},{5,6}}");
        String expected = "{{21.0, 26.0}, {37.0, 46.0}}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на произведение двух матриц пройден");
    }

    @Test (timeout = 100)
    public void vectorExpressionCalc() throws CalcException {
        Var var = parser.calc("{2,3}/(20/2)");
        String expected = "{0.2, 0.3}";
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на операции с приоритетом у вектора пройден");
    }

    @Test (timeout = 100)
    public void createVarCalc() throws CalcException {
        parser.calc("A=3+5*2");
        Var var=Var.createVar("A");
        double expected = 13.0;
        assert var != null;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("Тест на создание переменной пройден");
    }

    @Test (timeout = 30)
    public void createAndPrintScalar() {
        Var var=Var.createVar("-25");
        double expected = -25.0;
        assert var != null;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("Тест на создание переменной типа Scalar пройден");
    }

    @Test (timeout = 30)
    public void createAndPrintVector() {
        Var var=Var.createVar("{2,5,2.5}");
        String expected = "{2.0, 5.0, 2.5}";
        assert var != null;
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на создание переменной типа Vector пройден");
    }

    @Test (timeout = 30)
    public void createAndPrintMatrix() {
        Var var=Var.createVar("{{2,5.2,2.5},{7.1,8,9}}");
        String expected = "{{2.0, 5.2, 2.5}, {7.1, 8.0, 9.0}}";
        assert var != null;
        String actual = var.toString();
        assertEquals(expected, actual);
        System.out.println("Тест на создание переменной типа Matrix пройден");
    }


}