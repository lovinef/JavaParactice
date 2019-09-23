package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
*
* 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
* */
public class P4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        String input = "";
        int N;
        int avg;
        int total;
        int targetCnt = 0;
        String[] scores = null;
        for(int i=0 ; i < C ; i++){
            input = br.readLine();
            scores = input.split(" ");
            N = Integer.parseInt(scores[0]);

            // 초기화
            total = 0;
            avg = 0;
            targetCnt = 0;

            // 평균 구하기
            for(int j = 1 ; j < N ; j++){
                total += Integer.parseInt(scores[j]);
            }

            avg = total / N;
            for(int j = 1 ; j < N ; j++){
                if(Integer.parseInt(scores[j]) > avg){
                    targetCnt++;
                }
            }

            String result = String.format("%.3f", Math.round(targetCnt * 100000.0 / N) / 1000.0);
            System.out.println(result + "%");
        }
    }
}
