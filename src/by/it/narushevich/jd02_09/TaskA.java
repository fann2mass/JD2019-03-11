package by.it.narushevich.jd02_09;

import by.it.narushevich.jd02_09.beans.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskA {

    static Users users = null;

    public static void main(String[] args) throws JAXBException {
        String xml = "D:\\Marianna\\JD2019-03-20\\src\\by\\it\\narushevich\\jd02_09\\users+xsd.xml";
        String toXml = "D:\\Marianna\\JD2019-03-20\\src\\by\\it\\narushevich\\jd02_09\\users+xsd+jaxb.xml";
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        try (FileInputStream fis = new FileInputStream(xml)) {
            users = (Users) unmarshaller.unmarshal(fis);
            System.out.println(users);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        try (FileOutputStream fis = new FileOutputStream(toXml)) {
            marshaller.marshal(users, fis);
            marshaller.marshal(users, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
