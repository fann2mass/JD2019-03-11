package by.it.narushevich.jd02_07;

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

public class TaskC {

    public static void main(String[] args) throws SAXException, IOException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        File xsdFile = new File(getPath("users.xsd"));

        String xml = getPath("users+xsd.xml");

        Schema schema = schemaFactory.newSchema(xsdFile);
        Validator validator = schema.newValidator();
        try (FileReader reader = new FileReader(xml)
        ) {
            Source source = new StreamSource(reader);
            validator.validate(source);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
            System.out.flush();
            throw e;
        }
        System.out.println("ok");
    }

    private static String getPath(String name) {
        String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathPack = TaskC.class.getPackage().getName().replace(".", File.separator);
        return userDir + pathPack + File.separator + name;
    }
}
