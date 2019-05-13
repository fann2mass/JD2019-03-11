package by.it.bolotko.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StAXHandler {

    private static String xml = "src/by/it/bolotko/jd02_07/parkings.xml";

    public static void main(String[] args) {
        XMLInputFactory InputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream = new FileInputStream(xml)) {
            XMLStreamReader reader = InputFactory.createXMLStreamReader(fileInputStream);

            StAXParser instance = new StAXParser(reader);
            String txt = instance.Parse();
            System.out.println(txt);

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
