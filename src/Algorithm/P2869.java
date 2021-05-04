package Algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제
땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

출력
첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.

2 1 5 -> 4
5 1 6 -> 2
100 99 1000000000 -> 999999901
*/
public class P2869 {
    /**
     * 문제풀이 방법 1
     * @param up : 낮에 올라가는 높이
     * @param down : 밤에 미끄러지는 높이, 정상에서는 미끄러지지 않음
     * @param height : 나무 막대 높이
     * @return : 나무 막대를 모두 올라가는데 걸리는 일 수
     */
    public static int climb(final int up, final int down, final int height){
        int spendDay = 0;
        int nowHeight = 0;

        while(true){
            spendDay++;         // 날짜 경과

            nowHeight += up;    // 올라감

            if(nowHeight >= height){ // 올라간 이후 높이 측정
                break;
            }

            nowHeight -= down;  // 내려감
        }

        return spendDay;
    }

    /**
     * 문제풀이 방법 2
     * @param up : 낮에 올라가는 높이
     * @param down : 밤에 미끄러지는 높이, 정상에서는 미끄러지지 않음
     * @param height : 나무 막대 높이
     * @return : 나무 막대를 모두 올라가는데 걸리는 일 수
     */
    public static int climb2(final int up, final int down, final int height){
        // 최종 소요일
        int spendDay = 0;

        // 하루에 올라가는 높이
        int upForDay = up - down;

        spendDay++; // 첫째날 무조건 올라감
        int heightAfterHalfDay = height - up;   // 첫째날 무조건 올라가고 남은 높이

        spendDay += heightAfterHalfDay / upForDay;  // 첫째날 올라가고 남은 높이에 대한 일수 계산

        if(heightAfterHalfDay % upForDay != 0){ // 나머지가 있으면 다음날 올라감
            spendDay ++;
        }

        return spendDay;
    }

    public static int[] getNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        String[] split = readLine.split(" ");

        int[] inputInt = new int[3];
        inputInt[1] = Integer.parseInt(split[1]);
        inputInt[0] = Integer.parseInt(split[0]);
        inputInt[2] = Integer.parseInt(split[2]);

        return inputInt;
    }

    public static void main(String[] args) throws IOException {
        int[] numbers = getNumbers();
        System.out.println(climb2(numbers[0], numbers[1], numbers[2]));

//        2 1 5 -> 4
//        5 1 6 -> 2
//        100 99 1000000000 -> 999999901
//        System.out.println(climb2(2,1,5));
//        System.out.println(climb2(5,1,6));
//        System.out.println(climb2(100,99,1000000000));
    }
}
