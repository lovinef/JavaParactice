public class TestMain2 {
    public static void process(Runnable r){
        r.run();
    }

    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("hello world1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world2");
            }
        };

        process(r1);
        process(r2);

        process(() -> System.out.println("hello world3"));
    }
}
