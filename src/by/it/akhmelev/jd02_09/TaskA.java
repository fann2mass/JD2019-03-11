package by.it.akhmelev.jd02_09;

import by.it.akhmelev.jd02_09.beans.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskA {

    public static void main(String[] args) throws JAXBException, IOException {
        String fromXml = "src/by/it/akhmelev/jd02_09/users+xsd.xml";
        String toXml = "src/by/it/akhmelev/jd02_09/users+xsd+jaxb.xml";
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Users users;
        try (FileInputStream fileInputStream = new FileInputStream(fromXml)) {
            users = (Users) unmarshaller.unmarshal(fileInputStream);
            System.out.println(users);
        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try (FileOutputStream fileOutputStream = new FileOutputStream(toXml)) {
            marshaller.marshal(users, fileOutputStream);
            marshaller.marshal(users, System.out);
        }
    }
}
