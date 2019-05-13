package by.it.khlystunova.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class SaxHandler extends DefaultHandler {

    private StringBuilder value;
    private String tab;

    @Override
    public void startDocument() {
        tab="";
        value = new StringBuilder();
    }

    @Override
    public void endDocument() {
        System.out.println("--");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.print(tab + "<"+ qName);
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            System.out.printf(" %s=\"%s\"",
                    attributes.getLocalName(i),
                    attributes.getValue(i)
            );
        }
        System.out.println(">");
        tab = tab +"\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String text = value.toString().trim();
        if(!text.isEmpty()){
            System.out.println(tab + text);
            value.setLength(0);
        }
        tab=tab.substring(1);
        System.out.println(tab+"</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
      value.append(ch,start,length);
    }
}

