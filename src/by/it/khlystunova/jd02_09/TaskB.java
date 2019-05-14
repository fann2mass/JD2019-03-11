package by.it.khlystunova.jd02_09;

import by.it.khlystunova.jd02_09.beans.Clients;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskB {

    static Clients clients;

    public static void main(String[] args) throws JAXBException, IOException {

        readXml();
        saveXml();


    }

    static void readXml() throws JAXBException, IOException {
        System.out.println("========readXML========");
        String FROM_XML ="src/by/it/khlystunova/jd02_09/clients+xsd.xml";//демаршализация
        JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        try(FileInputStream inputStream = new FileInputStream(FROM_XML)){
            TaskB.clients =(Clients) unmarshaller.unmarshal(inputStream);
            System.out.println(clients);
        }

    }

    static void saveXml() throws JAXBException, IOException {
        System.out.println("========saveXML========");
        String TO_XML ="src/by/it/khlystunova/jd02_09/resultB.xml";
        JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        try(FileOutputStream out = new FileOutputStream(TO_XML)){
            marshaller.marshal(TaskB.clients,out);
            marshaller.marshal(TaskB.clients,System.out);
        }
    }
}
