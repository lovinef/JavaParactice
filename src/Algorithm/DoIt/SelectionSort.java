package Algorithm.DoIt;
/*
* 선택된 값과 배열중 가장 작은 수와 교체
* */
public class SelectionSort {
    public static void selectionSort(int[] x){
        int temp = 0;
        int minLocation = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i < x.length - 1 ; i++){
            minLocation = i+1;
            for(int j=i+1 ; j < x.length - 1 ; j++){
                // 최소값이 나온 위치를 찾는다.
                if(x[i] > x[j]) minLocation = j;
            }

            if(x[i] > x[minLocation]){
                temp = x[i];
                x[i] = x[minLocation];
                x[minLocation] = temp;
            }

            // 출력
            sb.setLength(0);
            for(int n : x){
                sb.append(n).append(" ");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{6,4,3,7,1,9,8,};
        selectionSort(x);
    }
}
