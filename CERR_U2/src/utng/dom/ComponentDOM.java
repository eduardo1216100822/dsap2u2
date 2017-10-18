package utng.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.Component;


public class ComponentDOM {
	private String pathFile = "C:\\Users\\Eduardo\\eclipse-workspace\\CERR_U2\\src\\data\\components.xml";

	public void add(Component data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			Element components = document.getDocumentElement();
			//Create component tag
			Element component = document.createElement("component");
			//Create id tag
			Element compId = document.createElement("compId");
			compId.appendChild(document.createTextNode(data.getCompId()));
			component.appendChild(compId);
			//Create instrumentId tag
			Element instrumentId = document.createElement("instrumentId");
			instrumentId.appendChild(document.createTextNode(String.valueOf(data.getInstrumentId())));
			component.appendChild(instrumentId);
			//Create componentId tag
			Element componentId = document.createElement("componentId");
			componentId.appendChild(document.createTextNode(String.valueOf(data.getComponentId())));
			component.appendChild(componentId);
			//Create username tag
			Element username = document.createElement("username");
			username.appendChild(document.createTextNode(data.getUsername()));
			component.appendChild(username);
			components.appendChild(component);
			//Write to file
			DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String compId) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("component");
			for(int i=0;i<nodeList.getLength();i++) {
				Element component = (Element)nodeList.item(i);
				if(component.getElementsByTagName("compId").item(0).getTextContent().equals(compId)) {
					component.getParentNode().removeChild(component);
				}
				
			}
			DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Component data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList=document.getElementsByTagName("component");
			for(int i=0;i<nodeList.getLength();i++) {
				Element component = (Element)nodeList.item(i);
				if(component.getElementsByTagName("compId").item(0).getTextContent().equals(data.getCompId())) {
					component.getElementsByTagName("instrumentId").item(0).setTextContent(String.valueOf(data.getInstrumentId()));
					component.getElementsByTagName("componentId").item(0).setTextContent(String.valueOf(data.getComponentId()));
					component.getElementsByTagName("username").item(0).setTextContent(data.getUsername());
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Component findById(String compId) {
		Component component = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList=document.getElementsByTagName("component");
			for(int i=0;i<nodeList.getLength();i++) {
				Element c = (Element)nodeList.item(i);
				if(c.getElementsByTagName("compId").item(0).getTextContent().equals(compId)) {
				component = new Component();
				component.setCompId(compId);
				component.setInstrumentId(Integer.parseInt((c.getElementsByTagName("instrumentId").item(0).getTextContent())));
				component.setComponentId(Integer.parseInt(c.getElementsByTagName("componentId").item(0).getTextContent()));
				component.setUsername(c.getElementsByTagName("username").item(0).getTextContent());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return component;
	}
	
	public List<Component> getComponents(){
		List<Component> components = new ArrayList<Component>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList= document.getElementsByTagName("component");
		for(int i=0;i<nodeList.getLength();i++) {
			Element c= (Element)nodeList.item(i);
			Component component = new Component();
			component.setCompId(c.getElementsByTagName("compId").item(0).getTextContent());
			component.setInstrumentId(Integer.parseInt(c.getElementsByTagName("instrumentId").item(0).getTextContent()));
			component.setComponentId(Integer.parseInt(c.getElementsByTagName("componentId").item(0).getTextContent()));
			component.setUsername(c.getElementsByTagName("username").item(0).getTextContent());
			components.add(component);
		}
		return components;
	}
}
