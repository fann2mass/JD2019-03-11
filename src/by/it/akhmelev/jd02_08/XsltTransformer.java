package by.it.akhmelev.jd02_08;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XsltTransformer {
    public static void main(String[] args)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Source rules=new StreamSource(Path.XSL);
        Source xml=new StreamSource(Path.XML);
        Result html=new StreamResult(Path.HTML);
        Transformer transformer = transformerFactory.newTransformer(rules);
        transformer.transform(xml,html);

    }
}
