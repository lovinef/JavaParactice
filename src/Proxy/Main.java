package Proxy;

public class Main {
    public static void main(String[] args) {
        Service service = new Proxy();

        System.out.println(service.runSomething());
    }
}
