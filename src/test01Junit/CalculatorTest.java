package test01Junit;

public class CalculatorTest {
    public static void main(String[] args) {
        //创建对象，调用方法
        Calculator cal = new Calculator();
        int result = cal.add(1, 2);
        System.out.println(result);
    }
}
