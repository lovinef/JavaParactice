package Algorithm.DoIt;

public class Factorial {
    static int factorial(int n){
        if(n > 0)
            return n * factorial(n-1);
        else
            return 1;
    }

    static int factorial2(int n){
        int result = 1;
        for(int i = 1 ; i <= n ; i ++){
            result = result * i;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorial2(4));
    }
}
