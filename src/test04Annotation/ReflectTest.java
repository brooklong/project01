package test04Annotation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
*   *案例:
        *需求:
             写一个"框架"，不能改变该类的任何代码前提下,以帮我们创建任意类的对象，并且执行其中任意方法
 */


@pro(className = "test04Annotation.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    //创建任意类的对象，并且执行其中任意方法
        /*
        *   前提：不能改变该类的代码。创建任意类的对象，并且执行其中任意方法    */

        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;

        //2获取上边的注解对象
        //其实就是在内存中生成了一个该注解接口的实现类对象

        /*
        *   public class proImpl implements pro{
        *       String className(){
        *           return "test04Annotation.Demo1";
        *       }
        *
        *       String methodName(){
        *           return "show";
        *       }
        *
        *   }*/
        pro annotation = reflectTestClass.getAnnotation(pro.class);

        //3.调用注解对象中定义的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);


        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);




























        /*Person person = new Person();
        person.eat();*/

       /* //1.加载配置文件
        //1.1创建properties对象
        Properties pro = new Properties();

        //1.2加载配置文件，转换为一个集合
        //获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //2.获取配置文件中的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("MethodName");

        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);
*/
    }
}
