import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class SumTest {
    public static void main(String[] args) {
        List<Dish2> dishes = new ArrayList<Dish2>();
        for(int i=0 ; i < 10000000 ; i++){
            dishes.add(new Dish2("a" + i, i));
        }
        System.out.println(dishes.size() + " 객체 생성 완료.");


        System.out.println("foreach 문 테스트");
        long start = System.nanoTime();
        long sum = 0;
        for(Dish2 dish2 : dishes){
                sum += dish2.getCalories();
        }
        System.out.println(sum);
        System.out.println("foreach 문 테스트 : " + sum + " : "+ ((System.nanoTime() - start) / 1_000_000));

        System.out.println("Stream reduce 테스트");
        start = System.nanoTime();
        sum = dishes.stream().limit(10).map(Dish2::getCalories).reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("Stream reduce 테스트 : " + sum + " : "+ ((System.nanoTime() - start) / 1_000_000));

        System.out.println("Stream mapToInt 테스트");
        start = System.nanoTime();
        System.out.println(sum);
        System.out.println("Stream reduce 테스트 : " + dishes.parallelStream().mapToInt(Dish2::getCalories).sum() + " : "+ ((System.nanoTime() - start) / 1_000_000));
    }
}
