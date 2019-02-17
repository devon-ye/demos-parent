package org.devon.enums.demo;

/*
*@author  Devonmusa
*@version
*2017年1月16日 下午10:59:12
*
*/
public interface Food {

	enum Appetizer implements Food {
		SALAD,SOUP,SPRING_ROLLS
    }

	enum MainCourse implements Food {
		LASAGNE,BUFFERITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO
    }

	enum Dessert implements Food {
		TIRAMISU,GELATO,BLACK_FOREST_CAKE,FRUIT,CREME_CARAMEL
    }

	enum Coffee implements Food {
		BLACK_COFFEE,DEACF_COFFEE,ESPRESSO,LATTE,CAPPUCCINO,TEA,HERB_TEA
    }

}
