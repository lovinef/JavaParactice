package java8;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.net.SocketTimeoutException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ChainTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Dish dish = new Dish("test", false, 1000, Dish.Type.MEAT);

        // 동기화 작업
     /*   CompletableFuture.completedFuture(dish)
                .thenApply(d ->{
                    System.out.println("getName : " + d.getName());
                    return d;
                }).thenApply(d ->{
                    System.out.println("getCalories : " + d.getCalories());
                    return d;
                }).thenAccept(d ->{
                    System.out.println("isVegetarian : " + d.isVegetarian());
                });*/

        //addCalories(d);
        //System.out.println(d);
        long start = System.nanoTime();
//        java8.Dish.menu.parallelStream()
//                .forEach(d->{
//                    CompletableFuture.completedFuture(d).thenApply(dish1 -> {
//                        return addCalories(dish1);
//                    }).thenApplyAsync(dish2 ->{
//                        return addName(dish2);
//                    });
//                });
        Dish.menu.parallelStream()
                .forEach(d->{
                    addName(d);
                    addCalories(d);
                });
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println(invocationTime);
    }

    private static void delay(int ms){
        try{
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static Dish addCalories(Dish dish){
        delay(3000);
        dish.setCalories(dish.getCalories() + 1000);
        System.out.println("end addCalories : " + dish.getName());
        return dish;
    }

    private static Dish addName(Dish dish){
        delay(dish.getCalories());
        dish.setName("aaa" + dish.getName());
        System.out.println("end addName : " + dish.getName());
        return dish;
    }
}
