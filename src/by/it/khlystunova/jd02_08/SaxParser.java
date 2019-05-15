package by.it.khlystunova.jd02_08;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

class SaxParser {

     public static void main(String[] args)
             throws ParserConfigurationException, SAXException, IOException {

         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         SaxHandler handler = new SaxHandler();
         saxParser.parse(Path.XML,handler);

     }
}
