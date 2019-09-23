package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int M = Integer.parseInt(br.readLine());
        final String[] input = br.readLine().split(" ");

        int sum = 0;
        int max = 0;
        int score = 0;

        for(String str : input){
            score = Integer.parseInt(str);
            sum += score;
            max = Math.max(max, score);
        }

        System.out.println(Math.round((double) sum / max * 10000.0 / M) / 100.0);
    }

}
