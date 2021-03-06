package by.it.zalesky.jd02_09;

import by.it.zalesky.jd02_09.beans.Customers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskA {

    public static void main(String[] args) throws JAXBException, IOException {
        String fromXml = "src/by/it/zalesky/jd02_09/customers+xsd.xml";
        String toXml = "src/by/it/zalesky/jd02_09/customers+xsd+jaxb.xml";
        JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Customers customers;
        try (FileInputStream fileInputStream = new FileInputStream(fromXml)) {
            customers = (Customers) unmarshaller.unmarshal(fileInputStream);
            System.out.println(customers);
        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try (FileOutputStream fileOutputStream = new FileOutputStream(toXml)) {
            marshaller.marshal(customers, fileOutputStream);
            marshaller.marshal(customers, System.out);
        }
    }
}
