package org.devon.generics.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Devonmusa
 * @date 2017年8月16日
 */
public class GenericsTest {
	
	
	public static void main(String[] args) {
		
		FruitHelper fruitHelper = new FruitHelper();
		List<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(new Apple()); // Allowed, as Apple is a Fruit
		fruits.add(new Banana()); // Allowed, as Banana is a Fruit
		fruitHelper.addApple(fruits); // Allowed, as "Fruit super Apple"
		fruitHelper.eatAll(fruits); // Allowed

		Collection<Banana> bananas = new ArrayList<>();
		bananas.add(new Banana()); // Allowed
		// fruitHelper.addApple(bananas); // Compile error: may only contain
		// Bananas!
		fruitHelper.eatAll(bananas); // Allowed, as all Bananas are Fruits

		Collection<Apple> apples = new ArrayList<>();
		fruitHelper.addApple(apples); // Allowed
		apples.add(new GrannySmith()); // Allowed, as this is an Apple
		fruitHelper.eatAll(apples); // Allowed, as all Apples are Fruits.

		Collection<GrannySmith> grannySmithApples = new ArrayList<>();
		// fruitHelper.addApple(grannySmithApples); //Compile error: Not
		// allowed.
		// GrannySmith is not a supertype of Apple
		apples.add(new GrannySmith()); // Still allowed, GrannySmith is an Apple
		fruitHelper.eatAll(grannySmithApples);// Still allowed, GrannySmith is a
												// Fruit

		Collection<Object> objects = new ArrayList<>();
		fruitHelper.addApple(objects); // Allowed, as Object super Apple
		objects.add(new Shoe()); // Not a fruit
		objects.add(new IPhone()); // Not a fruit
		// fruitHelper.eatAll(objects); // Compile error: may contain a Shoe,
		// too!
	}
}
