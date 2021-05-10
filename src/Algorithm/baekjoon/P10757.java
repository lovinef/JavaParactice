package Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 문제
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 A와 B가 주어진다. (0 < A,B < 10^10000)
 * 9223372036854775807 9223372036854775808
 *
 * 출력
 * 첫째 줄에 A+B를 출력한다.
 * 18446744073709551615
 */
public class P10757 {
    private static String[] getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();

        return readLine.split(" ");
    }

    // 풀이 1. BigInteger 사용 (-2^2147483647 ~ +2^2147483647)
    public static BigInteger calculate(String num1, String num2){
        BigInteger bigInteger1 = new BigInteger(num1);
        BigInteger bigInteger2 = new BigInteger(num2);

        return bigInteger1.add(bigInteger2);
    }

    // 풀이 2. 배열 덧셈
    public static String calculateArray(String num1, String num2){
        // 두 배열중 큰 배열길이 +1로 결과 대상을 만들어둔다.(덧셈의 경우 한 자리수가 늘어날수 있다.)
        int maxLength = Math.max(num1.length(), num2.length());

        StringBuilder sb = new StringBuilder();

        // 덧셈 시작
        int sum = 0;
        boolean biggerThanTen = false;
        for (int i = 0; i <= maxLength; i++) {
            int int1 = num1.length() -1 >= i ? Integer.parseInt(num1.substring(num1.length() - 1 - i, num1.length() - i)) : 0;
            int int2 = num2.length() -1 >= i ? Integer.parseInt(num2.substring(num2.length() - 1 - i, num2.length() - i)) : 0;

            sum = int1 + int2;

            // 이전 계산에서 10보다 컸다면 1을 더한다.
            if(biggerThanTen){
                sum += 1;
            }

            // 더한 값이 10보다 큰지 검사
            if(sum >= 10){
                biggerThanTen = true;
            }else{
                biggerThanTen = false;
            }

            sb.insert(0, sum % 10);
        }

        // 맨 처음이 0으로 시작하면 제거
        if(sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String[] inputArray = getInput();
        System.out.println(calculateArray(inputArray[0], inputArray[1]));
//        System.out.println(calculateArray("9223372036854775807", "9223372036854775808"));
//        System.out.println(calculateArray("1234", "1234"));
//        System.out.println(calculateArray("1", "5135315135"));
    }
}
