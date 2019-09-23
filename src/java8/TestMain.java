package java8;

import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import org.omg.CORBA.portable.ApplicationException;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestMain {

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple() {

        }

        public Apple(int weight) {
            this.weight = weight;
        }

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }

    }

    public static class AppleCompartor implements Comparator<Apple> {
        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<Apple>();
        appleList.add(new Apple(20, "az"));
        appleList.add(new Apple(70, "b"));
        appleList.add(new Apple(50, "ab"));
        appleList.add(new Apple(10, "d"));
        appleList.add(new Apple(20, "ac"));


        // 1번 방법 : 함수 클래스 생성
        appleList.sort(new AppleCompartor());
        System.out.println(appleList.toString());

        // 2번 방법 : 익명 클래스 생성
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(appleList.toString());

        // 3번 방법 : 람다 표현식 사용
        appleList.sort((a, b) -> a.getWeight().compareTo(b.getWeight()));
        System.out.println(appleList.toString());

        // 4번 방법 : 메서드 레퍼런스 사용
        appleList.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(appleList.toString());

        // 5번 방법 : 메서드 레퍼런스 사용, 역정렬
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(appleList.toString());

        appleList.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));

        System.out.println(appleList.toString());

        List<Apple> appleList2 = appleList.stream().filter(a->a.getWeight() > 30).collect(Collectors.toList());
        System.out.println(appleList2.toString());


    }
}
