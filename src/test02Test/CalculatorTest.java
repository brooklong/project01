package test02Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test01Junit.Calculator;

public class CalculatorTest {

    /*
     *   初始化方法：
     *       用于资源的申请，所以测试方法在执行之前都会先执行该方法
     * */
    @Before
    public void inti(){
        System.out.println("inti");
    }

    /*
    *   释放资源的方法，
    *       在所有测试方法执行完后，都会自动执行该方法*/

    @After
    public void close(){
        System.out.println("close");
    }

    /*
    *   测试add方法*/
    @Test
    public void testAdd(){
//        System.out.println("我被执行！");
        //1.创建对象
        Calculator c = new Calculator();
        //2.调用方法
        int result = c.add(10, 2);

        System.out.println("testAdd");

//        System.out.println(result);
        //3.断言 我断言这个结果是12
        Assert.assertEquals(12,result);
    }


}
