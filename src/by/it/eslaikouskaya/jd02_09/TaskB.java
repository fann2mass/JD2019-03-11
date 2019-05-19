package by.it.eslaikouskaya.jd02_09;

import by.it.eslaikouskaya.jd02_09.beans.Cite;
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

	private static Cite cite = null;

	public static void main(String[] args) throws JAXBException {
		readXML();
		String json = getJson();
		readJson(json);
		saveXml();
	}

	private static void readXML() throws JAXBException {
		String xml = getPath("Boritorg+xsd+jaxb.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Cite.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		try (FileInputStream fis = new FileInputStream(xml)) {
			cite = (Cite) unmarshaller.unmarshal(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getJson() {
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		String json = gson.toJson(cite);
		System.out.println("=============== JSON FROM XML ===============");
		System.out.println(json);
		return json;
	}

	private static void readJson(String json) {
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		cite = gson.fromJson(json, Cite.class);
	}

	private static void saveXml() throws JAXBException {
		String xml2 = getPath("resultB.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Cite.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		try (FileOutputStream fos = new FileOutputStream(xml2)) {
			marshaller.marshal(cite, fos);
			System.out.println("=============== XML FROM JSON ===============");
			marshaller.marshal(cite, System.out);
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
