package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
* "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
* */
public class P8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rowCnt = Integer.parseInt(br.readLine());

        List<String> inputList = new ArrayList<>();

        for(int i=0 ; i < rowCnt ; i++){
            inputList.add(br.readLine());
        }

        for(String str : inputList){
            int total = 0;
            int point = 0;

            for(String s : str.split("")){
                if("O".equals(s)){
                    point++;
                    total += point;
                }else{
                    point = 0;
                }
            }

            System.out.println(total);
        }
    }
}
