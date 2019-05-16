package by.it.zalesky.jd02_09;

import by.it.zalesky.jd02_09.beans.Customers;
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
        JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
        String fromXml = "src/by/it/zalesky/jd02_09/customers+xsd.xml";
        String toXml = "src/by/it/zalesky/jd02_09/customers+xsd+jaxb.xml";
        Customers customers;
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        try (FileInputStream fileInputStream = new FileInputStream(fromXml)) {
            customers = (Customers) unmarshaller.unmarshal(fileInputStream);
            System.out.println("================ CUSTOMERS FROM XML ======================= ");
            System.out.println(customers);
        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try (FileOutputStream fileOutputStream = new FileOutputStream(toXml)) {
            marshaller.marshal(customers, fileOutputStream);
            System.out.println("================ XML FROM CUSTOMERS ======================= ");
            marshaller.marshal(customers, System.out);
        }


        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(customers);
        System.out.println("================ JSON FROM CUSTOMERS ======================= ");
        System.out.println(json);
        customers=gson.fromJson(json,Customers.class);
        System.out.println("================ CUSTOMERS FROM JSON ======================= ");
        System.out.println(customers);
    }
}
