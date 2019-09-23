import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class GenericTest {
    private static class TestClass<E>{
        private List<E> list;
        TestClass() {
            list = new ArrayList<>();
        }

        public List<E> getList() {
            return list;
        }
        public void setList(List<E> list) {
            this.list = list;
        }
    }

    public static void main(String[] args) {
        TestClass<String> tc = new TestClass();
        TestClass<HashMap<String, Object>> tc1 = new TestClass();

        tc.getList().add("aaa");
        tc.getList().add("bbb");
        tc.getList().add("ccc");
        tc.getList().add("ddd");
        tc.getList().add("ee");
        System.out.println(tc.getList().toString());
        IntStream.rangeClosed(1, 10).forEach(d ->{
            HashMap<String, Object> map = new HashMap<>();
            map.put(String.valueOf(d), "value is " + d);
            tc1.getList().add(map);
        });

        System.out.println(tc1.getList().toString());
    }
}
