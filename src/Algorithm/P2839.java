package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.

상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.

상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.

18  4
4   -1
6   2
9   3
11  3
*/
public class P2839 {
    /***
     * 적은 개수의 봉지를 배달할때 봉지 개수 구하기
     * @param N : 설탕 킬로그램
     * @return : 봉지 수
     */
    public static int calculate(final int N){
        int fiveCnt = N / 5;
        int cnt = 0;

        // 5로 나누어 떨어지는 경우
        if(N % 5 == 0){
            return N / 5;
        }

        // 5x + 3y = N
        // 최대 x 값을 구하면 최소 봉지수를 구할 수 있다.
        int x = N / 5;
        int y = 0;
        for (int i = x; i >= 0; i--) {  // 최소 봉지수를 구하기 위해 최대 5키로 봉지수를 시작으로 -1하며 계산
            int cur = N - (5 * i);  // 5키로 봉지뺀 나머지 키로수

            // 남은 키로수가 3으로 나눠 떨어진다면 최소 개수를 구한 것(0 % 3 = 0)
            if(cur % 3 == 0){
                y = cur / 3;
                return i + y;   // 5키로 최소 봉지수 + 3키로 봉지수
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 킬로그램

        int calculate = calculate(N);
        System.out.println(calculate);
    }
}
