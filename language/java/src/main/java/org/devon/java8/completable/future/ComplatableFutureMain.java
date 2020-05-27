package org.devon.java8.completable.future;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * @author dewen.ye
 * @date 2019/3/21 23:23
 */
public class ComplatableFutureMain {

	public static void main(String[] args) {
		Path path = Paths.get("data", "category");
		LoadTask task = new LoadTask(path);
		CompletableFuture<List<Product>> loadFunture = CompletableFuture.supplyAsync(task);

		CompletableFuture<List<Product>> completableSearch = loadFunture.thenApplyAsync(new SearchTask("love"));
		CompletableFuture<Void> completableWrite = completableSearch.thenAcceptAsync(new WriteTask());
		ComplatableFutureMain main= new ComplatableFutureMain();
		main.getResult();
		completableWrite.exceptionally(ex -> {
			System.out.println(new Date() + ": main : Exception:" + ex.getMessage());
			return null;
		});
	}

	public  void getResult() {
		CompletableFuture<Long> resultA = this.getA();
		CompletableFuture<Long> resultB = this.getB();
		CompletableFuture<Long> resultC = this.getB();
        long result = 0;
        try {
            result = resultA.get();
            if(result >2 ){
                resultB.cancel(true);
                resultC.cancel(true);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


	}


	public CompletableFuture<Long> getA() {
		return CompletableFuture.supplyAsync(new Supplier<Long>() {
			@Override
			public Long get() {
				System.out.println("thread A:" + Thread.currentThread().getName() + "start...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread A:" + Thread.currentThread().getName() + "end...");
				return 2L;
			}
		});
	}

	public CompletableFuture<Long> getB() {
		return CompletableFuture.supplyAsync(new Supplier<Long>() {
			@Override
			public Long get() {
				System.out.println("thread B:" + Thread.currentThread().getName() + "start...");
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread B:" + Thread.currentThread().getName() + "end...");
				return 0L;
			}
		});
	}

	public CompletableFuture<Long> getC() {
		return CompletableFuture.supplyAsync(new Supplier<Long>() {
			@Override
			public Long get() {
				System.out.println("thread C:" + Thread.currentThread().getName() + "start...");
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread C:" + Thread.currentThread().getName() + "end...");
				return 0L;
			}
		});
	}
}
