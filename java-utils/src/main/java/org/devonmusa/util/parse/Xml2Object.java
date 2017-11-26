package org.devonmusa.util.parse;

import java.io.File;


import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
*@author  Devonmusa
*@date 2017年1月17日 
*
*/
public class Xml2Object {

	public static Object getObject(String fileName) {
		int rootSize = 0;
		Object result = null;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = (Document) documentBuilder.parse(new File(fileName));
			Element root = (Element) document.getDocumentElement();
			if( root != null){
				rootSize = root.getElementCount();
			}
			Object child = null;
			Element childElement = null;
			//ToDO  alfter
			for (int i = 0; i < rootSize; i++) {
				childElement = root.getElement(i);
				child = childElement.getClass();
				System.out.println(child);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
