package by.it.bildziuh.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class StAXParser {

    public static void main(String[] args) throws XMLStreamException, IOException {

        StringBuilder tab = new StringBuilder();
        StringBuilder value = new StringBuilder();

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileReader fileReader = new FileReader(Path.XML)) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.print(tab + "<" + reader.getLocalName());
                        int length = reader.getAttributeCount();
                        for (int i = 0; i < length; i++) {
                            System.out.printf(" %s=\"%s\"",
                                    reader.getAttributeLocalName(i),
                                    reader.getAttributeValue(i)
                            );
                        }
                        System.out.println(">");
                        tab.append("\t");
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        String text = value.toString().trim();
                        if (!text.isEmpty()) {
                            System.out.println(tab + text);
                            value.setLength(0);
                        }
                        tab = new StringBuilder(tab.substring(1));
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        value.append(reader.getText());
                        break;


                }
            }
        }

    }
}