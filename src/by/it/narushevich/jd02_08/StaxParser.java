package by.it.narushevich.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class StaxParser {

    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (Reader reader = new FileReader(Path.XML)){
            xmlInputFactory.createXMLStreamReader(reader);
            while (reader.ready()){


            }
        }
    }
}
