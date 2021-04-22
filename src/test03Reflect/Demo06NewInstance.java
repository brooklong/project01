package test03Reflect;

import domain.Person;
import org.junit.Test;

import java.util.Random;

/*
*   通过反射创建对应的运行时类的对象
* */
public class Demo06NewInstance {

    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
        /*
            newInstance();调用次方法，创建对应的运行时类的对象Person
        *   要想次方法正常创建运行时类的对象，要求：
                1.运行时类必须提供空参的构造器
                2.空参构造器访问权限得够，通常设置为public*/
        Person person = personClass.newInstance();
        System.out.println(person);
    }

    @Test
    public void test3() throws IllegalAccessException, InstantiationException {
        int num = new Random(3).nextInt();//0,1,2
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "package domain";
                break;
        }

        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //次方法创建一个指定类的对象，classPath：指定类的全类名
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
}
