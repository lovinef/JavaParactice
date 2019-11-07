package Algorithm;

import java.util.*;

/*
* 첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다.
* (2 ≤ n ≤ 106) 다음 n개의 줄에는 출입 기록이 순서대로 주어지며, 각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다.
* "enter"인 경우는 출근, "leave"인 경우는 퇴근이다.
* 회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다.
* 사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.
*
* 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.
* */
public class P7785 {
    public static void main(String[] args) {
        int N = 4;
        String[] inputArray = new String[]{"Baha enter","Askar enter","Baha leave","Artem enter", "a enter"};

        HashMap<String, Integer> logMap = new HashMap<>();
        // 입력받은 순서대로 list에 저장
        String name = "";
        String inOutStr = "";
        int inOut = 0;  // 1 : in, -1 : out
        for(String input : inputArray){
            name = input.split(" ")[0];
            inOutStr = input.split(" ")[1];
            inOut = "enter".equals(inOutStr) ? 1 : -1;

            if(logMap.containsKey(name)){   // 해당 이름으로된 로그 기록이 있으면 inOut 값을 변경함.
                if(logMap.get(name) + inOut == 0){  // enter leave 인 경우 맵에서 삭제
                    logMap.remove(name);
                }else{
                    logMap.put(name, logMap.get(name) + inOut);
                }
            }else{
                logMap.put(name, inOut);
            }
        }

        // 이름 내림차순 정렬
        logMap.keySet().stream().sorted(Comparator.comparing(String::valueOf).reversed()).forEach(System.out::println);
    }
}
