package by.it.bolotko.jd02_09;

import by.it.bolotko.jd02_09.beans.Parkings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskB {

    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Parkings.class);
        Parkings parkings;
        String FromXml = "src/by/it/bolotko/jd02_09/parkings+xsd.xml";
        String ToXml = "src/by/it/bolotko/jd02_09/resultB.xml";
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        try (FileInputStream fileInputStream = new FileInputStream(FromXml)) {
            parkings = (Parkings) unmarshaller.unmarshal(fileInputStream);
        }
        Parkings PFX = parkings;

        readXML(PFX);
        saveXML(jaxbContext, ToXml, PFX);
        readJson(getJson(PFX));
    }

    private static void readXML(Parkings PFX) {
        System.out.println("==================== PARKINGS FROM XML ==============================");
        System.out.println(PFX);
    }

    private static void saveXML(JAXBContext jaxbContext, String ToXml, Parkings PFX) throws JAXBException, IOException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try (FileOutputStream fileOutputStreamStream = new FileOutputStream(ToXml)) {
            marshaller.marshal(PFX, fileOutputStreamStream);
            System.out.println("\n==================== XML FROM PARKINGS ==============================");
            marshaller.marshal(PFX, System.out);
        }
    }

    private static String getJson(Parkings PFX) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(PFX);
        System.out.println("\n==================== JSON FROM PARKINGS ==============================");
        System.out.println(json);
        return json;
    }

    private static void readJson(String json) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Parkings PFJ = gson.fromJson(json, Parkings.class);
        System.out.println("\n==================== PARKINGS FROM JSON  ==============================");
        System.out.println(PFJ.toString());
    }
}

