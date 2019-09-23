import java.util.stream.IntStream;

public class TestMain5 {
    public static void main(String[] args) {
        // 구구단
        long start = System.nanoTime();
        IntStream.rangeClosed(2, 9).forEach(a -> IntStream.rangeClosed(1, 9).forEach(b -> System.out.println(a +"/" + b + ":" + (a*b))));
        System.out.println("================ end : " + ((System.nanoTime() - start) / 1_000_000));

        // 구구단2 , 실행 순서는 보장되지 않음.
        start = System.nanoTime();
        IntStream.rangeClosed(2, 9).parallel().forEach(a -> IntStream.rangeClosed(1, 9).parallel().forEach(b -> System.out.println(a +"/" + b + ":" + (a*b))));
        System.out.println("================ end : " + ((System.nanoTime() - start) / 1_000_000));

        start = System.nanoTime();
        for(int a=2 ; a <= 9 ; a++){
            for(int b=1 ; b <= 9 ; b++){
                System.out.println(a +"/" + b + ":" + (a*b));
            }
        }
        System.out.println("================ end : " + ((System.nanoTime() - start) / 1_000_000));
    }
}
