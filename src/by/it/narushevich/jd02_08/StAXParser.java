package by.it.narushevich.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class StAXParser {

    private static String tab = "";
    private static StringBuilder text = new StringBuilder();

    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (FileReader reader = new FileReader(Path.XML)) {
            XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(reader);
            while (streamReader.hasNext()) {
                int type = streamReader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.print(tab + '<' + streamReader.getLocalName());
                        int length = streamReader.getAttributeCount();
                        for (int i = 0; i < length; i++) {
                            System.out.printf(" %s=\"%s\"",
                                    streamReader.getAttributeLocalName(i),
                                    streamReader.getAttributeValue(i)
                            );
                        }
                        System.out.println('>');
                        tab += '\t';

                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        String nodeText = text.toString().trim();
                        if (!nodeText.isEmpty()) {
                            System.out.println(tab + nodeText);
                            text.setLength(0);
                        }
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + streamReader.getLocalName() + '>');

                        break;
                    case XMLStreamConstants.CHARACTERS:
                        text.append(streamReader.getText());
                        break;
                }
            }
        }
    }
}