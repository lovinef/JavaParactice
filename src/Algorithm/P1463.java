package Algorithm;

/*
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
    첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
출력
    첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다
*/

public class P1463 {
    public static void main(String[] args) {
        final int N = 10;

        // 연산 최솟값 구하기... 3개 중 하나를 써야한다.
        /*
        * 3으로 나누어 떨어진다면 3으로 나눔.
        * 2로 나누어 떨어진다면 2로 나눔.
        * */
        int temp = N;
        int cnt = 0;
        while(true){
            cnt += 1;
            if((temp - 1) % 3 == 0) {
                temp = temp - 1;
            }else if (temp % 3 == 0) {
                temp = temp / 3;
            }else if (temp % 2 == 0) {
                temp = temp / 2;
            }else if((temp - 1) % 2 == 0){
                temp = temp - 1;
            }
            if(temp == 1){
                break;
            }
        }

        System.out.println(cnt);
    }
}
