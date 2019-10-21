package java8;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        String str = null;

        String newStr = Optional.ofNullable(str).map(s ->{
            return "abc " + s;
        }).orElse("");


        System.out.println(str);
        System.out.println("newStr " + newStr);
    }

}
