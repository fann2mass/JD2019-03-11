package by.it.narushevich.jd02_09;

import by.it.narushevich.jd02_09.beans.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskB {

    static Users users = null;

    public static void main(String[] args) throws JAXBException {
        readXML();
        String json = getJson();
        readJson(json);
        saveXml();
    }

    static void readXML() throws JAXBException {
        String xml = getPath("users+xsd+jaxb.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        try (FileInputStream fis = new FileInputStream(xml)) {
            users = (Users) unmarshaller.unmarshal(fis);
            System.out.println("=============== FROM XML TO BEAN ===============");
            System.out.println(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        String json = gson.toJson(users);
        System.out.println("\n=============== JSON FROM BEAN ===============");
        System.out.println(json);
        return json;
    }

    static void readJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        Users users = gson.fromJson(json, Users.class);
        System.out.println("\n=============== BEAN FROM JSON ===============");
        System.out.println(users);
    }

    static void saveXml() throws JAXBException {
        String xml2 = getPath("resultB.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        try (FileOutputStream fos = new FileOutputStream(xml2)) {
            marshaller.marshal(users, fos);
            System.out.println("\n=============== XML FROM JSON ===============");
            marshaller.marshal(users, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getPath(String name) {
        String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathPack = TaskB.class.getPackage().getName().replace(".", File.separator);
        return userDir + pathPack + File.separator + name;
    }
}
