package Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/
public class P2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());

        List<Integer> numList = new LinkedList<>();
        for(int i=0 ; i < N ; i++){
            numList.add(Integer.parseInt(br.readLine()));
        }

        // 중복제거, 정렬 처리 java 1.7
        numList.sort(Comparator.naturalOrder());
        List<Integer> sortedList = new LinkedList<>();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0 ; i < numList.size() ; i++){
            if(!sortedList.contains(numList.get(i))){
                sortedList.add(numList.get(i));
                sb2.append(numList.get(i)).append(" ");
            }
        }
        sb2.deleteCharAt(sb2.length()-1);
        System.out.println(sb2.toString());
    }
}
