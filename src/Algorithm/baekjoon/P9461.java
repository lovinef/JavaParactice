package Algorithm.baekjoon;

import java.net.CacheRequest;

/*
* 오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다.
* 첫 삼각형은 정삼각형으로 변의 길이는 1이다.
* 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다.
* 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
* 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다.
* P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
* N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.
*
* 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)
*
* 각 테스트 케이스마다 P(N)을 출력한다.
* */
public class P9461 {
    public static void main(String[] args) {
        int N = 100;
        System.out.println(getNum(N));
    }

    /*
        1, 1, 1, 2, 2, 3, 4, 5, 7, 9
        1번째 + 5번째 = 6번째
        2번째 + 6번째 = 7번째
        3번째 + 7번째 = 8번째
        4번째 + 8번째 = 9번째
        5번째 + 9번째 = 10번째
        6번째 + 10번째 = 11번째
        ...
        F(N) + F(N+4) = F(N+5)
        F(N-5) + F(N-1) = F(N)
    */
    public static long getNum(final int N){
        long result = 0;
        final int[] defaultResult = new int[]{1,1,1,2,2};
        long[] calculateResult = new long[N+1]; // 계산결과 누적

        // 5 보다 작은 경우 기본 값 리턴
        if(N <= 5) return defaultResult[N-1];

        for(int i=1 ; i <= N ; i++){
            if(i < 6){
                calculateResult[i] = defaultResult[i-1];
            }else{
                calculateResult[i] = calculateResult[i-5] + calculateResult[i-1];
            }
        }

        return calculateResult[N];
    }
}
