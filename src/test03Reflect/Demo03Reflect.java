package test03Reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Demo03Reflect {
    /*
    *   * 获取的功能：
				1.获取成员变量们
					* Field[] getFields()
					* Field getField(String name)

					* Field[] getDeclaredFields()
					* Field getDeclaredFields(String name)

				2.获取构造方法们
					* constructor<?>[] getConstructors()
					* constructor<T> getConstructor(类<?>... parameterTypes)

					* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
					* constructor<?>[] getDeclaredConstructors()

				3.获取成员方法们
					* Method() getMethods()
					* Method getMethod(String name,类<?>...parameterTypes)

					* Method() getDeclaredMethods()
					* Method getDeclaredMethod(String name,类<?>...parameterTypes)

				4.获取类名
					* String getName()*/
    public static void main(String[] args) throws Exception {

        /*
        *
				2.获取构造方法们
					* constructor<?>[] getConstructors()
					* constructor<T> getConstructor(类<?>... parameterTypes)

					* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
					* constructor<?>[] getDeclaredConstructors()
*/


        //1.获取Person的class对象
        Class<Person> personClass = Person.class;

//        constructor<T> getConstructor(类<?>... parameterTypes)
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);//public domain.Person(java.lang.String,int)

        //创建对象
        Object person = constructor.newInstance("zhang",21);
        System.out.println(person);
        System.out.println("----------------------");


        Constructor<Person> constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        //创建空参对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);//Person{name='null', age=0, a='null', b='null', c='null', d='null'}
        System.out.println("----------------------------");

        //创建空参对象简化，Class.newInstance
        Person person2 = personClass.newInstance();
        System.out.println(person2);

    }
}
