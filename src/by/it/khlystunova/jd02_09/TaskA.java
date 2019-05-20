package by.it.khlystunova.jd02_09;

import by.it.khlystunova.jd02_09.beans.Clients;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskA {

    public static void main(String[] args) throws JAXBException,IOException {

        String FROM_XML ="src/by/it/khlystunova/jd02_09/clients+xsd.xml";//демаршализация
        String TO_XML ="src/by/it/khlystunova/jd02_09/clients+xsd+jaxb.xml";
        JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Clients clients;
        try(FileInputStream inputStream = new FileInputStream(FROM_XML)){
            clients =(Clients) unmarshaller.unmarshal(inputStream);
            System.out.println(clients);
        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try(FileOutputStream out = new FileOutputStream(TO_XML)){
            marshaller.marshal(clients,out);
            marshaller.marshal(clients,System.out);
        }
    }
}
