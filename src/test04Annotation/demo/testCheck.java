package test04Annotation.demo;

import javax.annotation.processing.Messager;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;

/*
*   简单的测试框架
*
*   当主方法执行后，会自动执行被检测的所以方法（加了check注解发方法），判断是否有异常，记录到文件中 */
public class testCheck {
    public static void main(String[] args) throws IOException {
        //1.创建计算机对象
        Calculator cal = new Calculator();

        //2.获取字节码文件对象
        Class aClass = cal.getClass();

        int number = 0;//异常出现的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        //3.获取所有的方法
        Method[] aClassMethods = aClass.getMethods();
        for (Method aClassMethod : aClassMethods) {
            //4.判断方法是否有Check注解
            if (aClassMethod.isAnnotationPresent(Check.class)){
                //5.有，执行
                try {
                    aClassMethod.invoke(cal);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    //6.捕获异常

                    //记录到文件中
                    number++;
                    bw.write(aClassMethod.getName()+"方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称"+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("========================");
                    bw.newLine();
                }
            }
        }

        bw.write("本次测试一共出现 "+number+" 次异常");

        bw.flush();
        bw.close();

    }
}
