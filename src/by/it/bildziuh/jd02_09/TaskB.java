package by.it.bildziuh.jd02_09;

import by.it.bildziuh.jd02_09.beans.Users;
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
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        String fromXml = "src/by/it/bildziuh/jd02_09/users+xsd.xml";
        String toXml = "src/by/it/bildziuh/jd02_09/users+xsd+jaxb.xml";
        Users users;
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        try (FileInputStream fileInputStream = new FileInputStream(fromXml)) {
            users = (Users) unmarshaller.unmarshal(fileInputStream);
            System.out.println("================ USERS FROM XML ======================= ");
            System.out.println(users);
        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try (FileOutputStream fileOutputStream = new FileOutputStream(toXml)) {
            marshaller.marshal(users, fileOutputStream);
            System.out.println("================ XML FROM USERS ======================= ");
            marshaller.marshal(users, System.out);
        }


        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(users);
        System.out.println("================ JSON FROM USERS ======================= ");
        System.out.println(json);
        users=gson.fromJson(json,Users.class);
        System.out.println("================ USERS FROM JSON ======================= ");
        System.out.println(users);
    }
}
