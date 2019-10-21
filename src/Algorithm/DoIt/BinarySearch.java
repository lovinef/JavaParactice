package Algorithm.DoIt;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        final int[] inputList = new int[]{15,27,39,77,92,108,121};
        final int searchValue = 1;

        int frontIndex = 0;
        int lastIndex = inputList.length - 1;
        int middleIndex = (frontIndex + lastIndex) / 2;

        int sameIndex = 0;
        while(true){
            if (middleIndex < 0 || frontIndex > lastIndex){
                sameIndex = -1;
                break;
            }

            if(searchValue < inputList[middleIndex]){  // 중간값보다 작은 경우
                lastIndex = middleIndex - 1;
            }else if(searchValue > inputList[middleIndex]){ // 중간값보다 큰 경우
                frontIndex = middleIndex + 1;
            }else if(searchValue == inputList[middleIndex]){
                sameIndex = middleIndex;
                break;
            }else{
                sameIndex = -1;
                break;
            }

            System.out.println(frontIndex + " / " + middleIndex + " / " + lastIndex);
            middleIndex = (frontIndex + lastIndex) / 2;
        }

        System.out.println(sameIndex);
    }
}
