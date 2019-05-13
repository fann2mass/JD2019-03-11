package by.it.zalesky.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {

    private static String fileName = "src/by/it/zalesky/jd02_07/customers.xml";

    public static void main(String[] args) {


        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SaxHandler handler = new SaxHandler();
            saxParser.parse(new File(fileName), handler);
            } catch (IOException e) {
            e.printStackTrace();
            } catch (ParserConfigurationException e) {
            e.printStackTrace();
            } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
