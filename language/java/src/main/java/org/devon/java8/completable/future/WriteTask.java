package org.devon.java8.completable.future;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author dewen.ye
 * @date 2019/3/21 23:22
 */
public class WriteTask implements Consumer<List<Product>> {


	public WriteTask() {
	}

	@Override
	public void accept(List<Product> products) {
		System.out.println("consumer:" + products);
	}
}
