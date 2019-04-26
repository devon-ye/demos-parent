package org.devon.java8.completable.future;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author dewen.ye
 * @date 2019/3/21 23:23
 */
public class ComplatableFutureMain {

    public static void main(String[] args) {
        Path path = Paths.get("data","category");
        LoadTask task = new LoadTask(path);
        CompletableFuture<List<Product>> loadFunture = CompletableFuture.supplyAsync(task);

        CompletableFuture<List<Product>> completableSearch = loadFunture.thenApplyAsync(new SearchTask("love"));
        CompletableFuture<Void> completableWrite = completableSearch.thenAcceptAsync(new WriteTask());

        completableWrite.exceptionally(ex->{
            System.out.println(new Date() + ": main : Exception:"+ex.getMessage());
            return null;
        });
    }
}
