package by.it.zalesky.jd02_08;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransformer {
    public static void main(String[] args) throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();

        Source template=new StreamSource(Path.XSL);
        Source xml=new StreamSource(Path.XML);
        Result html=new StreamResult(Path.HTML);
        Transformer transformer = tf.newTransformer(template);
        transformer.transform(xml,html);

    }
}

