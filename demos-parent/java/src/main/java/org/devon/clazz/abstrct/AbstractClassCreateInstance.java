package org.devon.clazz.abstrct;

public class AbstractClassCreateInstance {
	public static void main(String args[]){
		/*
		 * abstract class haven't  abstract method,so don't to intance class
		 */
		// AbstractClass abstractClass = new AbstractClass();  
	}
}

abstract class  AbstractClass{
	
	public void print(){
		System.out.println("AbstractClass.print() is genereted method");
	}
}