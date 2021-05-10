package Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*

이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
*/

public class P1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        // 데이터 생성
        int makeDataCnt = 0;
        int firstNum = 0;
        int lastNum = 0;

        for(int i=1 ; i <= X ; i++){
            for(int j = 1 ; j <= i ; j++){
                makeDataCnt++;

                if(i % 2 != 0){ // 홀수인 경우 4,3,2,1 / 1,2,3,4
                    firstNum = i - j + 1;
                    lastNum = j;
                }else{          // 짝수인 경우 1,2,3,4 / 4,3,2,1
                    firstNum = j;
                    lastNum = i - j + 1;
                }

                if(makeDataCnt == X){
                    System.out.println(firstNum + "/" + lastNum);
                    return;
                }
            }
        }
    }
}
