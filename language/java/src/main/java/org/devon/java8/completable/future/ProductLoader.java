package org.devon.java8.completable.future;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

/**
 * @author dewen.ye
 * @date 2019/3/19 08:50
 */
public class ProductLoader implements Function<Path,Product> {

    public  List<Path> load(){
        return  null;
    }


    public ProductLoader() {
    }


    @Override
    public Product apply(Path path) {
        return null;
    }

    @Override
    public <V> Function<V, Product> compose(Function<? super V, ? extends Path> before) {
        return null;
    }

    @Override
    public <V> Function<Path, V> andThen(Function<? super Product, ? extends V> after) {
        return null;
    }
}
