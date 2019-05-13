package by.it.zalesky.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StAXRunner {

    private static String fileName = "src/by/it/zalesky/jd02_07/customers.xml";


    public static void main(String[] args) {

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream = new FileInputStream(new File(fileName))) {
                XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

                StAX instamce = new StAX(reader);
                String txt = instamce.parse();
            System.out.println(txt);


        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
          catch (IOException e) {
            e.printStackTrace();
        }


    }
}
