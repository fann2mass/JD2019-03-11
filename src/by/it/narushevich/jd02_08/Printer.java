package by.it.narushevich.jd02_08;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class Printer {

    private static String tab ="";

    static void printDom(Node node) {
        int type = node.getNodeType();
        switch (type) {
            case Node.ELEMENT_NODE: {
                System.out.print(tab+"<"+node.getNodeName().trim());

                if (node.hasAttributes()) {
                    NamedNodeMap attrs = node.getAttributes();
                    for (int i = 0; i < attrs.getLength(); i++)
                        printDom(attrs.item(i));
                }
                System.out.println(">");
                tab = tab + '\t';

                if (node.hasChildNodes()) {
                    NodeList children = node.getChildNodes();
                    for (int i = 0; i < children.getLength(); i++)
                        printDom(children.item(i));
                }
                break;
            }

            case Node.ATTRIBUTE_NODE: {
                System.out.print(" " + node.getNodeName() + "=\""+node.getNodeValue().trim()+"\"");
                break;
            }

            case Node.TEXT_NODE: {
                if (node.getTextContent().contains("\n")){
                    break;
                }
                System.out.println(tab+node.getNodeValue().trim());
                break;
            }
        }

        if (type == Node.ELEMENT_NODE) {
            tab = tab.substring(1);
            System.out.println(tab+"</"+node.getNodeName()+'>');
        }
    }
}
