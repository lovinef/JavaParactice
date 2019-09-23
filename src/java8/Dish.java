package java8;

import java.util.*;

public class Dish {

    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 1000, Dish.Type.MEAT),
                    new Dish("beef", false, 2000, Dish.Type.MEAT),
                    new Dish("chicken", false, 1500, Dish.Type.MEAT),
                    new Dish("french fries", true, 2000, Dish.Type.OTHER),
                    new Dish("rice", true, 1500, Dish.Type.OTHER),
                    new Dish("season fruit", true, 1000, Dish.Type.OTHER),
                    new Dish("pizza", true, 3000, Dish.Type.OTHER),
                    new Dish("prawns", false, 4000, Dish.Type.FISH),
                    new Dish("salmon", false, 1500, Dish.Type.FISH)
                    );
}