package Algorithm.DoIt;

public class BubbleSort {
    //    버블정렬
    static int[] bubbleSortAsc(int[] x){
        int temp = 0;
        int swapCnt = 0;
        for(int i=0 ; i < x.length ; i++){
            swapCnt = 0;
            for(int j=x.length - 1 ; j > i ; j--){
                if(x[j] < x[j-1]){  // 우측 값이 더 큰경우 swap
                    temp = x[j-1];  // 큰 수를 넣는다
                    x[j-1] = x[j];
                    x[j] = temp;
                    swapCnt++;
                }
            }

            if(swapCnt == 0)    break;
        }
        return x;
    }

    //    버블정렬 DESC 처리
    static int[] bubbleSortDesc(int[] x){
        int temp = 0;
        for(int i=0 ; i < x.length ; i++){
            for(int j=x.length - 1 ; j > i ; j--){
                if(x[j] > x[j-1]){  // 우측 값이 더 큰경우 swap
                    temp = x[j-1];  // 큰 수를 넣는다
                    x[j-1] = x[j];
                    x[j] = temp;
                }
            }
        }
        return x;
    }

    //    처음부터 정렬하는 버블정렬
    static int[] bubbleSortAscStart0(int[] x){
        int temp = 0;
        for(int i = x.length ; i > 0 ; i--){
            for(int j = 0 ; j < i - 1 ; j++){
                if(x[j] < x[j+1]){  // 우측 값이 더 큰경우 swap
                    temp = x[j+1];  // 큰 수를 넣는다
                    x[j+1] = x[j];
                    x[j] = temp;
                }
            }
        }
        return x;
    }

    // 버블정렬 프로세스를 보여준다.
    static int[] showBubbleSortProcess(int[] x){
        int temp = 0;
        int changeCnt = 0;  // swap 수
        int compareCnt = 0; // 비교수
        boolean isChange = false;   // 값 swap 여부

        for(int i=0 ; i < x.length ; i++){
            if(i < x.length -1)
                System.out.println("패스 " + (i+1) + " :");

            for(int j=x.length - 1 ; j > i ; j--){
                compareCnt++;

                if(x[j] < x[j-1]){  // 우측 값이 더 큰경우 swap
                    isChange = true;
                    changeCnt++;
                }else{
                    isChange = false;
                }

                System.out.println(makeSortProcess(x, j, isChange));

                if(isChange){       // swap
                    temp = x[j-1];
                    x[j-1] = x[j];
                    x[j] = temp;
                }
            }
        }

        System.out.println("비교를 " + compareCnt + "회 했습니다.");
        System.out.println("교환은 " + changeCnt + "회 했습니다.");
        return x;
    }

    public static StringBuilder makeSortProcess(int[] x, int compareLocation, boolean isChange){
        StringBuilder sb = new StringBuilder();

        sb.append("\t");
        for(int i=0 ; i < x.length ; i++){
            if(i == compareLocation - 1){
                sb.append(x[i]).append(isChange ? " + " : " - ");
            }else{
                sb.append(x[i]).append(" ");
            }
        }

        return sb;
    }

    /*
        양방향 버블 정렬
        홀수 번째 패스시 가장 작은 요소를 맨앞으로 옮김(우 -> 좌)
        짝수 번째 패스시 가장 큰 요소를 맨 뒤로 옮김(좌 -> 우)

        최악, 평균 복잡도는 O(n^2)를 가지고, 최상 복잡도는 O(n)을 가집니다.
    */
    public static int[] cocktailSort(int[] x){
        int temp = 0;

        int min = 0;        // 정렬 시작 위치
        int max = x.length -1; // 정렬 종료 위치

        boolean isChanged = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i < x.length ; i++){
            isChanged = false;
            // 오른쪽으로 이동하면서 정렬, 작은수가 왼쪽으로 이동
            for(int j = min ; j < max ; j++){
                if(x[j] > x[j+1]){  // 다음 수가 작으면 SWAP
                    temp = x[j+1];
                    x[j+1] = x[j];
                    x[j] = temp;

                    isChanged = true;
                }
                sb.setLength(0);
                for(int n : x){
                    sb.append(n).append(" ");
                }
                System.out.println(sb.toString());
            }
            System.out.println("오름 정렬 종료");
            if(!isChanged)  break; // 오름 정렬시 변화가 없다면 정렬 종료.
            // 좌측으로 이동하면서 정렬, 작은수가 왼쪽으로 이동
            for(int j=max ; j > min ; j--){
                if(x[j-1] > x[j]){  // 다음 수가 작으면 SWAP
                    temp = x[j];
                    x[j] = x[j-1];
                    x[j-1] = temp;
                }

                sb.setLength(0);
                for(int n : x){
                    sb.append(n).append(" ");
                }
                System.out.println(sb.toString());
            }

            min++;
            max--;
            System.out.println("내림 정렬 종료");
        }

        return x;
    }

    public static void main(String[] args) {
        int[] x = new int[]{6,4,3,7,1,9,8,};

        int[] sortedX = cocktailSort(x);

//        for(int n : sortedX){
//            System.out.println(n);
//        }
    }
}
