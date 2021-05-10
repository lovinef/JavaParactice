package Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.

입력
첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다
2
1
3
2
3

출력
각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.
6
10

제한
1 ≤ k, n ≤ 14
 */
public class P2775 {
    /*
        T개의 테스트 데이터 입력
        H, W, N (층수, 층의 방수, 손님 번호)
     */
    public static int[][] getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();

        int T = Integer.parseInt(readLine);

        int[][] inputArray = new int[T][2];

        for(int i=0 ; i < T ; i++){
            inputArray[i][0] = Integer.parseInt(br.readLine());   // k
            inputArray[i][1] = Integer.parseInt(br.readLine());   // n
        }

        return inputArray;
    }

    public static int calculate(final int k, final int n){
        // 1호에 산다면 무조건 1명
        if(n == 1){
            return 1;
        }

        // 0층에 산다면 무조건 n명
        if(k == 0){
            return n;
        }

        int[][] arr = new int[k+1][n+1];    // 0부터 시작이므로 +1
        // 호수별 실제 값을 계산한다.
        for(int i=0 ; i <= k ; i++){ // 층
            for(int j=1 ; j <= n ; j++){  // 호
                if(i == 0){
                    arr[i][j] = j;
                }else{
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }
        }

        return arr[k][n];
    }


    public static void main(String[] args) throws IOException {
        int[][] inputArrays = getInput();

        for (int[] inputArray : inputArrays) {
            int result = calculate(inputArray[0], inputArray[1]);
            System.out.println(result);
        }
    }
}
