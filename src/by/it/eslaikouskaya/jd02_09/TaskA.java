package by.it.eslaikouskaya.jd02_09;

import by.it.eslaikouskaya.jd02_09.beans.Cite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskA {

	public static void main(String[] args) throws JAXBException, IOException {
		String fromXml = "src/by/it/eslaikouskaya/jd02_09/Boritorg+xsd.xml";
		String toXml = "src/by/it/eslaikouskaya/jd02_09/Boritorg+xsd+jaxb.xml";
		JAXBContext jaxbContext = JAXBContext.newInstance(Cite.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Cite cite;
		try (FileInputStream fileInputStream = new FileInputStream(fromXml)) {
			cite = (Cite) unmarshaller.unmarshal(fileInputStream);
			System.out.println(cite);
		}

		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		try (FileOutputStream fileOutputStream = new FileOutputStream(toXml)) {
			marshaller.marshal(cite, fileOutputStream);
			marshaller.marshal(cite, System.out);
		}
	}
}