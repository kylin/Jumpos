package com.june.implemented.common.util;



import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class WSDLGetTargetNamespace {
	public static void main(String[] args) {
		String str = WSDLGetTargetNamespace.get("http://webservice.webxml.com.cn/WebServices/TrainTimeWebService.asmx?wsdl", "getStationAndTimeDataSetByTrainCode");
		System.out.println(str);
	}
	
	public static String get(String url,String actionName){
		if(url == null)
			return "";
		try {
			SAXReader saxReader = new SAXReader();
//				saxReader.setEncoding("gbk");
			Document document = null;
			if(url.startsWith("http://")){
				document = saxReader.read(url);
			}else{
				document = DocumentHelper.parseText(url);
			}
			Element rootResult = document.getRootElement();
			Iterator schemaIterator = rootResult.element("types").elementIterator("schema");
			while(schemaIterator.hasNext()){
				Element actions = (Element)schemaIterator.next();
				String targetNamespace = actions.attributeValue("targetNamespace");
				Iterator iterator = actions.elementIterator("element");
				while(iterator.hasNext()){
					Element element = (Element)iterator.next();
					String name = element.attributeValue("name");
					if(actionName.equals(name)){
						return targetNamespace;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	
}