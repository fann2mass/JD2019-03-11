package by.it.akhmelev.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler{

    private String tab;
    private StringBuilder text;

    @Override
    public void startDocument() throws SAXException {
        tab="";
        text=new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("--");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab+"<"+qName);
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            System.out.printf(" %s=\"%s\"",
                    attributes.getLocalName(i),
                    attributes.getValue(i)
            );
        }
        System.out.println(">");
        tab=tab+"\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String nodeText = text.toString().trim();
        if (!nodeText.isEmpty()){
            System.out.println(tab+nodeText);
            text.setLength(0);
        }
        tab=tab.substring(1);
        System.out.println(tab+"</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch,start,length);
    }
}
