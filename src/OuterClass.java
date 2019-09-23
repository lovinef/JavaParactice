class OuterClass {
    private String name;

    OuterClass(String name) {
        this.name = name;
    }

    static class InnerClass{
        static void showMe(){
            System.out.println("InnerClass showMe is called");
        }
    }
}
