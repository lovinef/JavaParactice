package Algorithm.baekjoon;

/*
* RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다.
* 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다.
* 집 i의 이웃은 집 i-1과 집 i+1이고, 첫 집과 마지막 집은 이웃이 아니다.
* 각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때,
* 모든 집을 칠하는 비용의 최솟값을 구하는 프로그램을 작성하시오.
*
* input
* 첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다.
* 둘째 줄부터 N개의 줄에 각 집을 빨강으로, 초록으로, 파랑으로 칠하는 비용이 주어진다.
* 비용은 1,000보다 작거나 같은 자연수이다.
*
* output
* 첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
* */
public class P1149 {
    public static void main(String[] args) {
        int N = 3; // N < 1,000
        int[][] inputArray = new int[][]{{26,40,83},{49,60,57},{13,89,99}};
        int[][] summaryArray = new int[N][3];

        // 첫번째 집에 해당하는 값 설정
        summaryArray[0][0] = inputArray[0][0];  // R
        summaryArray[0][1] = inputArray[0][1];  // G
        summaryArray[0][2] = inputArray[0][2];  // B

        for(int j=1 ; j < N ; j++){ // 집마다 최소값을 구한다.
            summaryArray[j][0] = Math.min(inputArray[j][1], inputArray[j][2]) + summaryArray[j-1][0];
            summaryArray[j][1] = Math.min(inputArray[j][0], inputArray[j][2]) + summaryArray[j-1][1];
            summaryArray[j][2] = Math.min(inputArray[j][0], inputArray[j][1]) + summaryArray[j-1][2];

            System.out.println(Math.min(inputArray[j][0], inputArray[j][2]));
        }
        System.out.println(summaryArray[N-1][1]);
        System.out.println(summaryArray[N-1][2]);
        System.out.println(summaryArray[N-1][0]);
    }
}
