package Java;

public class OuterClassMain {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("abcde");
        OuterClass.InnerClass.showMe();
    }
}
