package com.spring.helloword;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
*
*@author Devonmusa
*@date   2017年8月23日
*/
public class MainApp {
	
	public static void main(String[] args) {
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
		HelloWorld  helloWord = (HelloWorld) xmlBeanFactory.getBean("helloWorld");
		
		String message = helloWord.getMessage();
		System.out.println("message=" + message);
	}

}
