import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                    .filter(d-> d.getCalories() > 300)
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


        List<Integer> number = Arrays.asList(1,2,3,4,5);
        List<Integer> nn = number.stream()
                .map(a -> a*a)
                .collect(Collectors.toList());
        System.out.println(nn.toString());


        List<Integer> n1 = Arrays.asList(1,2,3);
        List<Integer> n2 = Arrays.asList(3,4);

        List<int[]> pairs =
                n1.stream()
                .flatMap(i -> n2.stream().map(j -> new int[]{i,j}))
                .collect(Collectors.toList());


        List<int[]> paris2 =
                n1.stream()
                .flatMap(i ->
                        n2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i,j}))
                .collect(Collectors.toList());
        System.out.println(paris2.toString());


        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("vegetrian");
        }


        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = 0;
        for(int n : numbers){
            sum += n;
        }
        System.out.println(sum);

        int newSum = numbers.stream().reduce(10, (a, b)->a+b);
        System.out.println(newSum);

        Optional<Integer> newSum2 = numbers.stream().reduce((a, b) -> (a+b));
        System.out.println(newSum2);

        int newSum3 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(newSum2);

    }
}
