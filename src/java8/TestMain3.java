package java8;

import java8.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestMain3 {
    public static void main(String[] args) {
        List<String> names =
                Dish.menu.stream()
                        .filter(d -> {
                            System.out.println("filtering " + d.getName());
                            return d.getCalories() > 300;
                        })
                        .map(d -> {
                            System.out.println("mapping " + d.getName());
                            return d.getName();
                        })
                        .limit(3)
                        .collect(Collectors.toList());
        System.out.println(names);


        List<Dish> vegetrianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(vegetrianMenu.toString());

        List<Dish> dishes = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());

        System.out.println(dishes.toString());

        List<Dish> noMeat = Dish.menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(noMeat.toString());


        String[] arrayOfWords = {"Hello", "World"};
        List<String> uc = Arrays.stream(arrayOfWords)
                .map(a -> a.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uc.toString());


        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> nn = number.stream()
                .map(a -> a * a)
                .collect(Collectors.toList());
        System.out.println(nn.toString());


        List<Integer> n1 = Arrays.asList(1, 2, 3);
        List<Integer> n2 = Arrays.asList(3, 4);

        List<int[]> pairs =
                n1.stream()
                        .flatMap(i -> n2.stream().map(j -> new int[]{i, j}))
                        .collect(Collectors.toList());


        List<int[]> paris2 =
                n1.stream()
                        .flatMap(i ->
                                n2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j}))
                        .collect(Collectors.toList());
        System.out.println(paris2.toString());


        if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("vegetrian");
        }


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        System.out.println(sum);

        int newSum = numbers.stream().reduce(10, (a, b) -> a + b);
        System.out.println(newSum);

        Optional<Integer> newSum2 = numbers.stream().reduce((a, b) -> (a + b));
        System.out.println(newSum2);

        int newSum3 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(newSum2);


        if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("has vegetrian");
        }

        if (Dish.menu.stream().anyMatch(a -> Dish.Type.MEAT.equals(a.getType()))) {
            System.out.println("has meat");
        }

        boolean isHealth = Dish.menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealth);

        boolean isHealthy = Dish.menu.stream().noneMatch(d -> d.getCalories() > 2000);
        System.out.println(isHealthy);

        boolean hasVegetirian = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .isPresent();

        Dish.menu.stream()
                .filter(d -> d.getCalories() > 500)
                .findAny()
                .ifPresent(a -> System.out.println("has 500 up" + a.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDisivibleByThree = someNumbers.stream()
                .map(a -> a * a)
                .filter(a -> a % 3 == 0)
                .findFirst();
        System.out.println(firstSquareDisivibleByThree);


        Optional<Integer> summ = someNumbers.stream().reduce(Integer::sum);
        System.out.println(summ.get() + 10);

        int caloriesSum = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(caloriesSum);

        int caloriies = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(caloriies);
    }
}
