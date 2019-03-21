package org.devon.java8.completable.future;


import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author dewen.ye
 * @date 2019/3/19 08:46
 */
public class LoadTask implements Supplier<List<Product>> {

    private Path path;

    public LoadTask(Path path) {
        this.path = path;
    }

    @Override
    public List<Product> get() {
        List<Product> productList = null;
        try {
            //todo
            productList = Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                    .parallel().filter(f -> f.toString()
                            .endsWith(".txt")).map(ProductLoader::load)
                    .collect(Collectors.toList());
        } catch (Exception e) {

        }
        return null;
    }
}
