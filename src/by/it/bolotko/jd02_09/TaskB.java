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
        readXML();
        saveXML();
        readJson(getJson());
   }

        private static void readXML() throws JAXBException {
            Parkings parkings;
            JAXBContext jaxbContext = JAXBContext.newInstance(Parkings.class);
            String FromXml = "src/by/it/bolotko/jd02_09/parkings+xsd.xml";
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            try (FileInputStream fileInputStream = new FileInputStream(FromXml)) {
                parkings = (Parkings) unmarshaller.unmarshal(fileInputStream);
                System.out.println("==================== PARKINGS FROM XML ==============================");
                System.out.println(parkings);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void saveXML() throws JAXBException, IOException {
            JAXBContext jaxbContext = JAXBContext.newInstance(Parkings.class);
            Parkings parkings;
            String FromXml = "src/by/it/bolotko/jd02_09/parkings+xsd.xml";
            String ToXml = "src/by/it/bolotko/jd02_09/resultB.xml";
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            try (FileInputStream fileInputStream = new FileInputStream(FromXml)) {
                parkings = (Parkings) unmarshaller.unmarshal(fileInputStream);
            }
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            try (FileOutputStream fileOutputStreamStream = new FileOutputStream(ToXml)) {
                marshaller.marshal(parkings, fileOutputStreamStream);
                System.out.println("==================== XML FROM PARKINGS ==============================");
                marshaller.marshal(parkings, System.out);
            }
        }

        private static String getJson() throws JAXBException, IOException {
            JAXBContext jaxbContext = JAXBContext.newInstance(Parkings.class);
            String FromXml = "src/by/it/bolotko/jd02_09/parkings+xsd.xml";
            Parkings parkings;
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            try (FileInputStream fileInputStream = new FileInputStream(FromXml)) {
                parkings = (Parkings) unmarshaller.unmarshal(fileInputStream);
            }

            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json = gson.toJson(parkings);
            System.out.println("==================== JSON FROM PARKINGS ==============================");
            System.out.println(json);
            return json;
        }

        private static void readJson(String json){
            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            Parkings parkings2 = gson.fromJson(json, Parkings.class);
            System.out.println("==================== PARKINGS FROM JSON  ==============================");
            System.out.println(parkings2.toString());
        }
    }

