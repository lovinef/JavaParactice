package Algorithm.DoIt;

import Java.GenericTest;
import kotlin.text.StringsKt;

public class GenericClassTester {
    static class GenericClass<T>{
        private T xyz;

        public GenericClass(T xyz) {
            this.xyz = xyz;
        }

        public T getXyz() {
            return xyz;
        }
    }

    public static void main(String[] args) {
        GenericClass<String> s = new GenericClass<String>("ABC");
        GenericClass<Integer> n = new GenericClass<Integer>(12345);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }
}
