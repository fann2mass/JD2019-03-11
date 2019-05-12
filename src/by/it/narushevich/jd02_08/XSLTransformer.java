package by.it.narushevich.jd02_08;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransformer {

    public static void main(String[] args) throws TransformerException {

        Source xml = new StreamSource(Path.XML);
        Result html = new StreamResult(Path.HTML);
        Source rules=new StreamSource(Path.XSL);

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer(rules);
        transformer.transform(xml,html);
    }
}
