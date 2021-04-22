package test03Reflect;

import domain.Person;

public class Demo01Reflect {
    /*
    *   获取class对象的三种方式：
			1.class.forName（“全类名”）：将字节码文件加载进内存，返回class对象
			2.类名.class：通过类名的属性class获取
			3.对象.getClass():getClass()这个方法在Object类中定义的。
			* */
    public static void main(String[] args) throws ClassNotFoundException {

        //1.class.forName（“全类名”）：将字节码文件加载进内存，返回class对象
        Class cls1 = Class.forName("domain.Person");
        System.out.println(cls1);

        //2.类名.class：通过类名的属性class获取
        Class cls2 = Person.class;
        System.out.println(cls2);

        //3.对象.getClass():getClass()这个方法在Object类中定义的。
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        //==去比较对象
        System.out.println(cls1==cls2);//true
        System.out.println(cls1==cls3);//true
        System.out.println(cls2==cls3);//true


    }
}
