package Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
public class P1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> inputStrList = new ArrayList<>();
        for(int i=0 ; i < N ; i++){
            inputStrList.add(br.readLine());
        }

        inputStrList.stream().distinct().sorted((o1, o2) -> {
            if(o1.length() > o2.length()){
                return 1;   // 길이가 짧은 것부터
            }else if (o1.length() == o2.length()){
                return o1.compareTo(o2);    // 길이가 같으면 사전 순으로
            }else{
                return -1;
            }
        }).forEach(System.out::println);
    }
}
