package Algorithm.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
public class P1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final long input = Integer.parseInt(br.readLine());

        List<Integer> inputList = new ArrayList<>();
        long temp = input;

        while(temp > 0){
            inputList.add((int) (temp % 10));
            temp = temp / 10;

            if(temp == 0){
                temp = -1;
            }
        }

        // 오름차순 정렬
        inputList.sort(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Integer integer : inputList) {
            sb.append(integer);
        }
        System.out.println(sb.toString());
    }
}
