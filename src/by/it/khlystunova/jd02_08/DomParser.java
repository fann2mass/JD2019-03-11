package by.it.khlystunova.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class DomParser {

    private static String tab ="";

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document parse = documentBuilder.parse(Path.XML);
            Element documentElement = parse.getDocumentElement();
            printDom(documentElement);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("ERROR:" + e.toString());
        }
    }

    private static void printDom(Node node){

        short nodeType = node.getNodeType();

        switch (nodeType){

            case Node.ELEMENT_NODE:
                System.out.print(tab + "<"+ node.getNodeName().trim());
                if(node.hasAttributes()) {
                    NamedNodeMap attributes = node.getAttributes();
                    for (int i = 0; i < attributes.getLength(); i++)
                        printDom(attributes.item(i));

                }
                System.out.println(">");
                tab = tab +"\t";

                if(node.hasChildNodes()){
                    NodeList childNodes = node.getChildNodes();
                    for (int i = 0; i < childNodes.getLength(); i++)
                        printDom(childNodes.item(i));

                }
                break;
            case Node.ATTRIBUTE_NODE:
                System.out.print(" " + node.getNodeName() + "=\""+node.getNodeValue().trim()+"\"");
                break;
            case Node.TEXT_NODE:
                if(node.getTextContent().contains("\n")){
                    System.out.print("");
                    break;
                }

                System.out.println(tab + node.getNodeValue().trim());
                break;

        }

        if (nodeType == Node.ELEMENT_NODE) {
            tab = tab.substring(1);
            System.out.println(tab+"</"+node.getNodeName()+'>');
        }

    }
}
