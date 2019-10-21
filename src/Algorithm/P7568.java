package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class P7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCnt = Integer.parseInt(br.readLine());

        LinkedList<HashMap<String, Integer>> inputList = new LinkedList<>();
        String inputStr = "";
        for(int i=0 ; i < totalCnt ; i++){
            inputStr = br.readLine();
            HashMap<String, Integer> peopleMap = new HashMap<>();
            peopleMap.put("weight", Integer.parseInt(inputStr.split(" ")[0]));
            peopleMap.put("height", Integer.parseInt(inputStr.split(" ")[1]));

            inputList.add(peopleMap);
        }

        //  두 사람 A 와 B의 덩치가 각각 (x,y), (p,q)라고 할 때 x>p 그리고 y>q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"
        int biggerThenMeCnt = 1;
        for(int i = 0 ; i < inputList.size() ; i++){
            biggerThenMeCnt = 1;

            for(int j = 0 ; j < inputList.size() ; j++) {
                // 나보다 크면 biggerThenMeCnt + 1
                if(inputList.get(i).get("weight") < inputList.get(j).get("weight")
                    && inputList.get(i).get("height") < inputList.get(j).get("height")
                ){
                    biggerThenMeCnt ++;
                }
                inputList.get(i).put("rank", biggerThenMeCnt);
            }
        }

        // 출력
        StringBuilder sbResult = new StringBuilder();
        for(int i=0 ; i < inputList.size() ; i++){
            if(i > 0){
                sbResult.append(" ");
            }
            sbResult.append(inputList.get(i).get("rank"));
        }
        System.out.println(sbResult.toString());
    }
}
