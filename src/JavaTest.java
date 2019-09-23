import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


enum Calculator{
    CALC_A{
        long calculate(long value){return value;}
        long caculate2(long value){return value + 100;}
    },
    CALC_B{
        long calculate(long value){return value * 10;}
        long caculate2(long value){return value * 100;}
    },
    CALC_C{
        long calculate(long value){return value - 10;}
        long caculate2(long value){return value - 100;}
    };

    abstract long calculate(long value);
    abstract long caculate2(long value);
}

enum CalculatorTypeJava7{
    CALC_A{
        long calculate(long value){return value;}
    },
    CALC_B{
        long calculate(long value){return value * 10;}
    },
    CALC_C{
        long calculate(long value){return value - 10;}
    };

    abstract long calculate(long value);
}

enum CalculatorTypeJava8{
    CALC_A(value -> value),
    CALC_B(value -> value * 10),
    CALC_C(value -> value -10);

    private Function<Long, Long> expression;

    CalculatorTypeJava8(Function<Long, Long> expression){ this.expression = expression;}

    public long calculate(long value){return expression.apply(value);}
}

enum PayGroup{
    CASH("현금", Arrays.asList("A1", "A2", "A3", "A4","A5")),
    CARD("카드", Arrays.asList("B1", "B2", "B3", "B4","B5")),
    ETC("기타", Arrays.asList("E1", "E2"));

    private String title;
    private List<String> payList;

    PayGroup(String title, List<String> payList) {
        this.title = title;
        this.payList = payList;
    }

    public static PayGroup findByPayCode(String code){
        return Arrays.stream(PayGroup.values())
                .filter(pg -> pg.hasPayCode(code))
                .findAny()
                .orElse(null);
    }

    public boolean hasPayCode(String code){
        return payList.stream().anyMatch(p ->p.equals(code));
    }

    public String getTitle() {  return title;   }
}

enum PayGroupForEnum{
    CASH("현금", Arrays.asList(PayCodeEnum.PAY_CODE_A1, PayCodeEnum.PAY_CODE_A2)),
    CARD("카드", Arrays.asList(PayCodeEnum.PAY_CODE_B1, PayCodeEnum.PAY_CODE_B2)),
    ETC("기타", Arrays.asList(PayCodeEnum.PAY_CODE_E1));

    private String title;
    private List<PayCodeEnum> payList;

    PayGroupForEnum(String title, List<PayCodeEnum> payList) {
        this.title = title;
        this.payList = payList;
    }

    public static PayGroupForEnum findByPayCode(PayCodeEnum code){
        return Arrays.stream(PayGroupForEnum.values())
                .filter(pg -> pg.hasPayCode(code))
                .findAny()
                .orElse(null);
    }

    public boolean hasPayCode(PayCodeEnum code){
        return payList.stream().anyMatch(p -> p == code);
    }

    public String getTitle() {  return title;   }
}

enum PayCodeEnum{
    PAY_CODE_A1("A1"),
    PAY_CODE_A2("A2"),
    PAY_CODE_B1("B1"),
    PAY_CODE_B2("B2"),
    PAY_CODE_E1("E1");

    private String payCode;
    PayCodeEnum(String payCode) {   this.payCode = payCode;    }
    public String getPayCode() {    return payCode; }
}

public class JavaTest {
    public static void main(String[] args) {
        // JAVA 7
        System.out.println(CalculatorTypeJava7.CALC_A.calculate(1000));
        System.out.println(CalculatorTypeJava7.CALC_B.calculate(1000));
        System.out.println(CalculatorTypeJava7.CALC_C.calculate(1000));

        // JAVA 8
        System.out.println(CalculatorTypeJava8.CALC_A.calculate(1000));
        System.out.println(CalculatorTypeJava8.CALC_B.calculate(1000));
        System.out.println(CalculatorTypeJava8.CALC_C.calculate(1000));

        System.out.println(PayGroup.findByPayCode("A1"));
        System.out.println(PayGroupForEnum.findByPayCode(PayCodeEnum.PAY_CODE_A1));

        System.out.println(Calculator.CALC_A.caculate2(1000));
    }
}
