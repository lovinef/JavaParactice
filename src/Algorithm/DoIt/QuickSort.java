package Algorithm.DoIt;

public class QuickSort {
    /*
    * a[pl] >= x가 성립할때까지 pl을 오른쪽으로 스캔
    * a[pr] <= x가 성립할때까지 pr을 왼쪽으로 스캔
    *
    * 1) 두 그룹으로 나누어 정렬하는 방식
    * */
    public static void quickSort(int[] x, int left, int right){
        int pl = left;
        int pr = right;
        int pivot = x[(left + right) / 2]; // 가운데 값

        int temp = 0;
        int plIndex = 0;
        int prIndex = 0;
        while (pl <= pr) {  // 크로스 전까지 진행함.
            while(x[pl] < pivot)    pl++;
            while(x[pr] > pivot)    pr--;

            if (pl <= pr) {
                plIndex = pl++;
                prIndex = pr--;

                temp = x[plIndex];
                x[plIndex] = x[prIndex];
                x[prIndex] = temp;
            }
        }

        if(left < pr)   quickSort(x, left, pr);
        if(pl < right)   quickSort(x, pl, right);
    }

    // 진행상황을 출력한다.
    public static void showArray(int[] x){
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        for(int n : x){
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] x = new int[]{6,4,3,7,1,9,8,};
        quickSort(x, 0, x.length - 1);
        showArray(x);
    }
}
