import javax.swing.text.html.Option;
import java.awt.image.ImageProducer;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class TestMain4 {
    public static void main(String[] args) {
        boolean booleanTest1 = Dish.menu.stream().anyMatch(d -> d.getCalories() > 500);
        System.out.println(booleanTest1);

        // calories > 500 인 첫번째 Dish 객체의 데이터 출력
        // findAny(첫번째로 찾은 데이터 출력, 순서 상관 없음)
        Dish.menu.stream().filter(d -> d.getCalories() > 500).findAny().ifPresent(dish -> System.out.println(dish.getName() + " / " + dish.getCalories()));
        // findFirst(첫번째 데이터 출력)
        Dish.menu.stream().filter(d -> d.getCalories() > 500).findFirst().ifPresent(dish -> System.out.println(dish.getName() + " / " + dish.getCalories()));

        System.out.println("forEach start");
        Dish.menu.stream().filter(d -> d.getCalories() > 600).forEach(d ->{
            System.out.println(d.getName());
        });
        System.out.println("forEach end");

        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .filter(d -> "pork".equals(d.getName()))
                .findFirst()
                .ifPresent(d -> System.out.println(d.toString()));

        //Dish.menu.stream().map(Dish::getCalories).forEach(System.out::println);

        String[] strArray = {"a","b","c","d","e"};
        Arrays.stream(strArray).filter("d"::equals).findFirst().ifPresent(System.out::println);
        Arrays.stream(strArray)
                .filter("e"::equals)
                .findFirst()
                .ifPresent(System.out::println);



        int sum = Dish.menu.stream().filter(d -> d.getCalories() > 10000).mapToInt(Dish::getCalories).sum();
        System.out.println(sum);

        int sum2 = Dish.menu.stream().filter(d -> d.getCalories() > 500).map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println(sum2);
    }
}
