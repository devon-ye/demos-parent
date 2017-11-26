package com.generics.demo;

import java.util.Collection;

/**
*
*@author Devonmusa
*@date   2017年8月16日
*/
public class FruitHelper {
	
	 public void eatAll(Collection<? extends Fruit> fruits) {}

     public void addApple(Collection<? super Apple> apples) {}
}


class Shoe {}
class IPhone {}
interface Fruit {}
class Apple implements Fruit {}
class Banana implements Fruit {}
class GrannySmith extends Apple {}