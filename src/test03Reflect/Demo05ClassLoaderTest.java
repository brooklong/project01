package test03Reflect;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/*
*   类的加载器*/
public class Demo05ClassLoaderTest {
    @Test
    public void test(){
        //对应自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = Demo05ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器方法getParent（）；获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);//扩展类加载器

        //调用扩展类加载器方法getParent（）；获取引导类加载器
        //null 获取不到引导类加载器，它主要负责java核心类库，无法自定义加载
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
    }

    /*
    *   Properties:读取配置文件*/
    @Test
    public void test2() throws Exception {
        //读取配置文件方式一：
        //此时的文件默认在当前的module下
        Properties pro = new Properties();
       /* FileInputStream fis = new FileInputStream("src\\jdbc.properties");
        pro.load(fis);*/

        //读取配置文件的方式二：
        //此时的配置文件默认识别问当前module的src下
        ClassLoader classLoader = Demo05ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pro.load(is);

        String user = pro.getProperty("user");
        String password = pro.getProperty("passWord");
        System.out.println("user="+user+",password="+password);

    }
}
