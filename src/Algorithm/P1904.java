package Algorithm;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.CheckedOutputStream;

/*
지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.
어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다.
결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.
그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다.
예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.) 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.
우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다.
단 타일들은 무한히 많은 것으로 가정하자.

첫 번째 줄에 자연수 N이 주어진다.(N ≤ 1,000,000)

첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.

4 -> 5
*/
public class P1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        final String binaryZeroStr = String.format("%0" + N + "d", 0);  // 0으로만 이루어진 N자리 문자
        final StringBuilder binaryOneStr =  new StringBuilder(binaryZeroStr.replaceAll("0", "1"));  // 1으로만 이루어진 N자리 문자
        boolean process = true; // 실행 여부

        int movePosition = 0;   // 이동 위치
        int tryCnt = 1;
        while (process) {
            // 0 입력
            binaryOneStr.delete(movePosition, movePosition + 2);   // 이동하려는 위치의 숫자 삭제
            binaryOneStr.insert(movePosition, "00");         // 이동하려는 위치에 00 입력

            // 1입력
            if(movePosition >= 1){
                binaryOneStr.delete(movePosition - 1, movePosition);
                binaryOneStr.insert(movePosition -1 , "1");
            }

            System.out.println(movePosition + "/" + binaryOneStr);

            movePosition++; // 위치 증가

            if(tryCnt > binaryOneStr.length() / 2){
                break;
            }
        }
    }
}
