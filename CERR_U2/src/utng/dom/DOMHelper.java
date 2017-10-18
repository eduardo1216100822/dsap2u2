package utng.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class DOMHelper {
	public static Document getDocument(String pathFile) {
		Document document=null;
		try {
			DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
			DocumentBuilder biulder = factory.newDocumentBuilder();
			document = biulder.parse(new File(pathFile));
		}catch(Exception e) {
			document=null;
			e.printStackTrace();
		}
		return document;
	}
	
	public static String saveXMLContent(Document document, String pathFile) {
		String result="";
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(pathFile);
			transformer.transform(domSource, streamResult);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
