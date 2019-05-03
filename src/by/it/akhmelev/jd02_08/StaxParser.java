package by.it.akhmelev.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class StaxParser {
    public static void main(String[] args)
            throws IOException, XMLStreamException {
        String tab="";
        StringBuilder text=new StringBuilder();

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (Reader fileReader=new FileReader(Path.XML)){
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(fileReader);
            while (reader.hasNext()){
                int type = reader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.print(tab+"<"+reader.getLocalName());
                        int length = reader.getAttributeCount();
                        for (int i = 0; i < length; i++) {
                            System.out.printf(" %s=\"%s\"",
                                    reader.getAttributeLocalName(i),
                                    reader.getAttributeValue(i)
                            );
                        }
                        System.out.println(">");
                        tab=tab+"\t";

                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        String nodeText = text.toString().trim();
                        if (!nodeText.isEmpty()){
                            System.out.println(tab+nodeText);
                            text.setLength(0);
                        }
                        tab=tab.substring(1);
                        System.out.println(tab+"</"+reader.getLocalName()+">");

                        break;
                    case XMLStreamConstants.CHARACTERS:
                        text.append(reader.getText());
                        break;
                }
            }

        }

    }
}
