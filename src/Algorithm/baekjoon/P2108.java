package Algorithm.baekjoon;

/*
산술평균 A : N개의 수들의 합을 N으로 나눈 값
중앙값 B: N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 C: N개의 수들 중 가장 많이 나타나는 값
범위 D: N개의 수들 중 최댓값과 최솟값의 차이

첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
둘째 줄에는 중앙값을 출력한다.
셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
넷째 줄에는 범위를 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<HashMap<String, Integer>> inputList = new ArrayList<>();
        for(int i=0 ; i < N ; i ++){
            HashMap<String, Integer> inputMap = new HashMap<>();
            inputMap.put("number", Integer.parseInt(br.readLine()));
            inputMap.put("sameCnt", 0);
            inputList.add(inputMap);
        }

        // 정렬
        inputList.sort(new Comparator<HashMap<String, Integer>>() {
            @Override
            public int compare(HashMap<String, Integer> o1, HashMap<String, Integer> o2) {
                return o1.get("number").compareTo(o2.get("number"));
            }
        });

        // 산술평균
        int A =  0;
        int sumA = 0;
        for(int i=0 ; i < inputList.size() ; i ++){
            sumA += inputList.get(i).get("number");    // 산술평균 합
        }
        A = Math.round((float)sumA / N);

        // 중앙값
        int B = 0;
        if(inputList.size() % 2 == 0){
            B = inputList.get(inputList.size() / 2).get("number");
        }else{
            if(inputList.size() == 1){
                B = inputList.get(0).get("number");
            }else{
                B = inputList.get((inputList.size() / 2) + 1).get("number");
            }
        }

        // 범위
        int D = 0;
        D = inputList.get(0).get("number") - inputList.get(inputList.size()-1).get("number");

        // 최빈값
        int C = 0;
        int maxSameCnt = 0;
        for(int i=0 ; i < inputList.size() ; i++){
            for(int j=0 ; j < inputList.size() ; j++) {
                if(inputList.get(j).get("number") == inputList.get(i).get("number")){
                    inputList.get(i).put("sameCnt", inputList.get(i).get("sameCnt") + 1);
                }
            }
        }

        inputList.sort(new Comparator<HashMap<String, Integer>>() {
            @Override
            public int compare(HashMap<String, Integer> o1, HashMap<String, Integer> o2) {
                return o1.get("sameCnt").compareTo(o2.get("sameCnt"));
            }
        }.thenComparing(new Comparator<HashMap<String, Integer>>() {
            @Override
            public int compare(HashMap<String, Integer> o1, HashMap<String, Integer> o2) {
                return o1.get("number").compareTo(o2.get("number"));
            }
        }));

        if(inputList.size() > 1){
            if(inputList.get(0).get("sameCnt") == inputList.get(1).get("sameCnt")){
                C = inputList.get(1).get("number");
            }else{
                C = inputList.get(0).get("number");
            }
        }else{
            C = inputList.get(0).get("number");
        }


        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
    }
}
