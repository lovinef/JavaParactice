import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestMain2 {
    public static void main(String[] args) {
        int num1 = 734;
        int num2 = 893;

        int reverseNum1 = reverseInt(num1);
        int reverseNum2 = reverseInt(num2);

        System.out.println(Math.max(reverseNum1, reverseNum2));
    }

    private static int reverseInt(int num){
        int result=0;

        while(num != 0){
            result = result * 10 + (num % 10);
            num /= 10;
        }

        return result;
    }
}
