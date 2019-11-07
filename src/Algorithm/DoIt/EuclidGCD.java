package Algorithm.DoIt;

public class EuclidGCD {
    static int gcd(int x, int y){
        if(y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    // 두 수를 나눈 나머지가 0일때 나눈수가 최대공약수가 된다.
    static int gcd2(final int x, final int y){
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        int temp = 0;
        while(min != 0){
            temp = max % min;
            max = min;
            min = temp;
        }

        return max;
    }

    // 배열 a 모든 요소의 최대공약수를 구해라.
    static int gcdArray(int[] a){
        int result = 0;
        if(a == null)   result = 0;
        else if(a.length == 1)  result = a[0];
        else{
            for(int i=0 ; i < a.length-1 ; i++){
                result = gcd(a[i], a[i+1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("gcd is : " + gcd(24, 4));
        System.out.println("gcd2 is : " + gcd2(24, 4));
        System.out.println("gcd array is : " + gcdArray(new int[]{2,4,6,8}));
    }
}
