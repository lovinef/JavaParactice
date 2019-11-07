package Algorithm.DoIt;

public class C05Q5 {
    static void recure3(int n){
        if (n > 0) {
            recure3(n-1);
            recure3(n-2);
            System.out.println(n);
        }
    }

    static void recure3N(int n){

    }

    public static void main(String[] args) {
        recure3(5);
    }
}
