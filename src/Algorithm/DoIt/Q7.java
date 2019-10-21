package Algorithm.DoIt;

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("10진수를 기수 변환합니다.");
        System.out.print("변환하는 음이 아닌 정수 : ");
        final int inputNum = sc.nextInt();
        System.out.print("어떤 진수로 변환할까요? : ");
        final int jinsu = sc.nextInt();

        int calNum = inputNum;
        StringBuilder sb = new StringBuilder();
        while(true){
            if(calNum == inputNum){     // 첫번째 단계
                System.out.println(jinsu + "|\t" + calNum);
            }else if(calNum / jinsu == 0){  // 마지막 단계
                System.out.println("  \t" + calNum);
                break;
            }else{
                System.out.println(jinsu + "|\t" + calNum + "\t... " + calNum % jinsu);
            }
            calNum = calNum / jinsu;
            sb.insert(0, calNum % jinsu);
        }
        System.out.println(sb.toString());
    }
}
