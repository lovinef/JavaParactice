package Algorithm.DoIt;

/*
    정렬되지 않은 부분의 첫번째 요소를 정렬된 열의 마지막부터 알맞는 위치에 삽임하며 정렬
    시간복잡도 : O(n2)
*/
public class InsertionSort {
    // 기본 삽입 정렬(오름차순 정렬)
    public static void insertionSort(int[] x){
        StringBuilder sb = new StringBuilder();

        int temp = 0;
        for(int i=1 ; i < x.length ; i++){
            for(int j = i ; j > 0 ; j--){
//                System.out.println(x[j-1] + ":" + x[j]);
                if(x[j-1] > x[j]){
                    temp = x[j];
                    x[j] = x[j-1];
                    x[j-1] = temp;
                }else{
                    break;
                }
            }
            showArray(x, sb);
        }
    }

    // 진행상황을 출력한다.
    public static void showArray(int[] x, StringBuilder sb){
        sb.setLength(0);
        for(int n : x){
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] x = new int[]{6,4,3,7,1,9,8,};
        insertionSort(x);
    }
}
