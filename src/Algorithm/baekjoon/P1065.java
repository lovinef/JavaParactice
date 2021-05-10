package Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다.
* 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
* N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
*
* 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 * */
public class P1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int totalCnt = 0;
        for(int i=1 ; i <= N ; i++){
            if(isHanSu(i)) totalCnt++;
        }
        System.out.println(totalCnt);
    }

    private static boolean isHanSu(int n){
        boolean result = true;

        String nStr = String.valueOf(n);
        int beforeDiff = 0;
        int newDiff = 0;
        for(int i=0 ; i < nStr.length() - 1 ; i++){
            if(i == 0){
                beforeDiff =  Integer.parseInt(nStr.substring(i, i+1)) - Integer.parseInt(nStr.substring(i+1, i+2));
            }else{
                newDiff =  Integer.parseInt(nStr.substring(i, i+1)) - Integer.parseInt(nStr.substring(i+1, i+2));

                if(beforeDiff != newDiff){
                    result = false;
                    break;
                }else{
                    beforeDiff = newDiff;
                }
            }
        }

        return result;
    }
}
