package java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class completableFutuerTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int num = 100;

        CompletableFuture cf1 = CompletableFuture.completedFuture(num)
                .thenApplyAsync(sNum -> {
                    System.out.println("first start");
                    return sNum + 100;
                }).thenAcceptAsync(aNum ->{
                    Dish.menu.stream().filter(dish -> dish.getType() == Dish.Type.MEAT).forEach(d -> System.out.println("MEAT : " + d.getName()));
                    System.out.println("first end");
                });

        CompletableFuture cf2 = CompletableFuture.completedFuture(num)
                .thenApplyAsync(sNum -> {
                    System.out.println("second start");
                    return sNum;
                }).thenAcceptAsync(aNum ->{
                    Dish.menu.stream().filter(dish -> dish.getType() == Dish.Type.FISH).forEach(d -> System.out.println("FISH : " + d.getName()));
                    System.out.println("second end");
                });

        CompletableFuture cf3 = CompletableFuture.completedFuture(num)
                .thenApplyAsync(sNum -> {
                    System.out.println("thrid start");
                    return sNum;
                }).thenAcceptAsync(aNum ->{
                    Dish.menu.stream().filter(dish -> dish.getType() == Dish.Type.OTHER).forEach(d -> System.out.println("OTHER : " + d.getName()));
                    System.out.println("thrid end");
                });

        CompletableFuture.allOf(cf1, cf3, cf2).join();
        System.out.println("all end");
    }
}
