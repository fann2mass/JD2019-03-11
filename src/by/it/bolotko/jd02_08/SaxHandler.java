package by.it.bolotko.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxHandler {

    private static String xml = "src/by/it/bolotko/jd02_07/parkings.xml";

    public static void main(String[] args) {

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SaxParser handler = new SaxParser();
            saxParser.parse(new File(xml), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
