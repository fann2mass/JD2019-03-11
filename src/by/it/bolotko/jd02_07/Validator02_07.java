package by.it.bolotko.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Validator02_07 {

    public static void main(String[] args) throws SAXException, IOException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "D:\\bolotko\\JD2019-03-11\\src\\by\\it\\bolotko\\jd02_07\\parkings+xsd.xml";
        String schemaName = "D:\\bolotko\\JD2019-03-11\\src\\by\\it\\bolotko\\jd02_07\\parkings.xsd";
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);

        Schema schema = schemaFactory.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        try (
                Reader reader = new FileReader(fileName)
        ) {
            Source source = new StreamSource(reader);
            validator.validate(source);
            System.out.println(fileName + " VALIDATE!");
            System.out.println("All Good! :)");
        } catch (Exception e) {
            System.out.println("Some problems");
            System.out.flush();
            throw e;
        }
    }
}
