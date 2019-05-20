package by.it.bolotko.jd02_09;

import by.it.bolotko.jd02_09.beans.Parkings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskA {

    public static void main(String[] args) throws JAXBException, IOException {
        String FromXml = "src/by/it/bolotko/jd02_09/parkings+xsd.xml";
        String ToXml = "src/by/it/bolotko/jd02_09/resultB.xml";
        JAXBContext jaxbContext = JAXBContext.newInstance(Parkings.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Parkings parkings;
        try (FileInputStream fileInputStream = new FileInputStream(FromXml)) {
            parkings = (Parkings) unmarshaller.unmarshal(fileInputStream);
            System.out.println("==================== PARKINGS FROM XML ==============================");
            System.out.println(parkings);
        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try (FileOutputStream fileOutputStreamStream = new FileOutputStream(ToXml)) {
            System.out.println("==================== XML FROM PARKINGS ==============================");
            marshaller.marshal(parkings, fileOutputStreamStream);
            marshaller.marshal(parkings, System.out);
        }
    }
}
