import javax.swing.text.html.Option;
import java.awt.image.ImageProducer;
import java.util.*;
import java.util.stream.Collectors;

public class TestMain4 {
    public static void main(String[] args) {
        List<String> dishes = new ArrayList<>();
        dishes = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(dishes.toString());

        boolean has500Cal = Dish.menu.stream().filter(a -> a.getCalories() > 500).findAny().isPresent();
        System.out.println(has500Cal);

        Dish itsMe = Dish.menu.stream().filter(a -> "chicken".equals(a.getName())).findAny().get();
        System.out.println(itsMe.getCalories());

        List<Integer> numList = Arrays.asList(4, 5, 3, 9);

        int numListSum1 = numList.stream().reduce(0, Integer::sum);
        System.out.println(numList);

        Optional<Integer> maxNum = numList.stream().reduce(Integer::max);
        System.out.println(maxNum);

        // 가장 많은 칼로리를 가지는 객체
        Dish imBig = Dish.menu.stream().sorted(Comparator.comparing(Dish::getCalories).reversed()).findFirst().get();
        System.out.println(imBig.getName() + "/ " + imBig.getCalories());

        Dish ImPizza = Dish.menu.stream().filter(a -> "pizza".equals(a.getName())).findAny().get();
        int pizzaCnt = (int) Dish.menu.stream().filter(a -> "pizza".equals(a.getName())).count();
        System.out.println(pizzaCnt);

        Dish smallestDish = Dish.menu.stream()
                                    .max(Comparator.comparing(Dish::getCalories)).get();
        System.out.println(smallestDish.getName());


    }
}
