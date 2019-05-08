package by.it.narushevich.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {

    private String tab;
    private StringBuilder text;

    @Override
    public void startDocument() {
        tab = "";
        text = new StringBuilder();
    }

    @Override
    public void endDocument() {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.print(tab+"<"+qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.printf(" %s=\"%s\"",
                    attributes.getLocalName(i),
                    attributes.getValue(i));
        }
        System.out.println(">");
        tab = tab + '\t';
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        String nodeText = text.toString().trim();
        if (!nodeText.isEmpty()){
            System.out.println(tab+nodeText);
            text.setLength(0);
        }
        tab=tab.substring(1);
        System.out.println(tab+"</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        text.append(ch,start,length);
    }
}
