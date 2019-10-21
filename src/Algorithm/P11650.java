package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
*/
public class P11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<HashMap<String, Integer>> inputListMap = new LinkedList<>();
        String inputStr = "";
        for(int i=0 ; i < N ; i ++){
            inputStr = br.readLine();

            HashMap<String, Integer> inputMap = new HashMap<>();
            inputMap.put("x", Integer.parseInt(inputStr.split(" ")[0]));
            inputMap.put("y", Integer.parseInt(inputStr.split(" ")[1]));
            inputListMap.add(inputMap);
        }

        inputListMap.sort(new Comparator<HashMap<String, Integer>>() {
            @Override
            public int compare(HashMap<String, Integer> o1, HashMap<String, Integer> o2) {
                if(o1.get("x") > o2.get("x")){  // x가 큰 순으로 정렬이 기본임.
                    return 1;
                }else if(o1.get("x") == o2.get("x")){   // x가 같은 경우 y 순서로 정렬.
                    if(o1.get("y") > o2.get("y")) {
                        return 1;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
        });

        for(int i=0 ; i < inputListMap.size() ; i ++){
            System.out.println(inputListMap.get(i).get("x") + " " + inputListMap.get(i).get("y"));
        }
    }
}
