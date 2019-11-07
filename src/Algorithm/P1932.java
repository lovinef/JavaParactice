package Algorithm;


import jdk.internal.util.xml.impl.Input;

/*
* 위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
* 맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때,
* 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라.
* 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
* 삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
*
*
* 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
* */
public class P1932 {
    public static void main(String[] args) {
        /*
        이동 가능 대각선 왼쪽 대각선 오른쪽만 가능.
        대각선 왼쪽 i, 대각선 오른쪽 i+1
        선택된 수의 합이 최대가 되는 경로 구하기.
        */
        // 입력 값
        int N = 5;
        final int[][] input = new int[][]{{7,0,0,0,0}, {3,8,0,0,0}, {8,1,0,0,0}, {2,7,4,4,0}, {4,5,2,6,5}};
        int[][] inputMaxSum = input.clone();
        // 다음줄 이동 가능 범위 : 대각선 왼쪽 i, 대각선 오른쪽 i+1
        // 마지막 좌 우 마지막에 있는 수는 길이 1개만 있고, 그 외의 수는 조건이 N -1 개씩임
        int result = 0;
        for(int i=1 ; i < N ; i++){
            for(int j=0 ; j < N ; j++){
                if (j == 0) {
                    inputMaxSum[i][j] += inputMaxSum[i-1][j];
                }else{
                    inputMaxSum[i][j] += Math.max(inputMaxSum[i-1][j-1], inputMaxSum[i-1][j]);
                }
                if (i == N - 1) {   // 마지막단계인 경우 최대값 추출
                    result = Math.max(result, inputMaxSum[i][j]);
                }
            }
        }

        System.out.println(result);
    }
}
