package Algorithm.DoIt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        String str = "1,2,3:4:5|6|7";

        String[] strArray = str.split(",|:");
        for(String aaaa : strArray){
            System.out.println(aaaa);
        }

    }
}
