package Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
* 첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.
* 첫째 줄에 N!을 출력한다.
* */
public class P10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(calculate(N));
    }

    private static long calculate(int N){
        if(N == 0) return 0;

        long result = 1;
        for(int i=1 ; i <= N ; i++){
            result = result * i;
        }

        return  result;
    }
}