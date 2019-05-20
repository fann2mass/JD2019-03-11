package by.it.khlystunova.jd02_09;

import by.it.khlystunova.jd02_09.beans.Clients;
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

    private static Clients clients;

    public static void main(String[] args) throws JAXBException, IOException {

        readXml();
        saveXml();
        String json = getJson();
        readJson(json);


    }

    private static void readXml() throws JAXBException, IOException {
        System.out.println("========readXML========");
        String FROM_XML ="src/by/it/khlystunova/jd02_09/clients+xsd.xml";//демаршализация
        JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        try(FileInputStream inputStream = new FileInputStream(FROM_XML)){
            TaskB.clients =(Clients) unmarshaller.unmarshal(inputStream);
            System.out.println(clients);
        }

    }

    private static void saveXml() throws JAXBException, IOException {
        System.out.println("========saveXML========");
        String TO_XML ="src/by/it/khlystunova/jd02_09/resultB.xml";
        JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try(FileOutputStream out = new FileOutputStream(TO_XML)){
            marshaller.marshal(TaskB.clients,out);
            marshaller.marshal(TaskB.clients,System.out);
        }

    }

    private static String getJson(){
        System.out.println("========getJson========");
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(TaskB.clients);
        System.out.println(json);
        return json;
    }

    private static void readJson(String json){
        System.out.println("========readJson========");
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Clients clients = gson.fromJson(json, Clients.class);
        System.out.println(clients.toString());
    }
}
