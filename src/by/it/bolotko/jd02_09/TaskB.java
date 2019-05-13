package by.it.bolotko.jd02_09;

import by.it.bolotko.jd02_09.beans.Parkings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskB {


    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Parkings.class);
        String FromXml = "src/by/it/bolotko/jd02_09/parkings+xsd.xml";
        String ToXml = "src/by/it/bolotko/jd02_09/parkings+xsd+jaxb.xml";
        Parkings parkings;
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        try (FileInputStream fileInputStream = new FileInputStream(FromXml)) {
           parkings = (Parkings) unmarshaller.unmarshal(fileInputStream);
           System.out.println("==================== USERS FROM XML ==============================");
           System.out.println(parkings);
        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try (FileOutputStream fileOutputStreamStream = new FileOutputStream(ToXml)) {
            marshaller.marshal(parkings,fileOutputStreamStream);
            System.out.println("==================== XML FROM USERS ==============================");
            marshaller.marshal(parkings,System.out);
        }

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        //GsonBuilder builder = (GsonBuilder) gson.toJson(parkings);

    }
}
