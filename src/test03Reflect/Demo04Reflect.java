package test03Reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Demo04Reflect {
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
           3.获取成员方法们
             * Method() getMethods()
             * Method getMethod(String name,类<?>...parameterTypes)

             * Method() getDeclaredMethods()
             * Method getDeclaredMethod(String name,类<?>...parameterTypes)
         */


        //1.获取Person的class对象
        Class<Person> personClass = Person.class;
        Method eatMethod = personClass.getMethod("eat");//方法名，参数列表
        Person p = new Person();
        //执行方法
        eatMethod.invoke(p);


        Method eatMethod1 = personClass.getMethod("eat", String.class);
        eatMethod1.invoke(p,"fan");
        System.out.println("--------------");

//        获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("==================");

        //获取类名
        String className = personClass.getName();
        System.out.println(className);//domain.Person  全类名（包名.类名）
    }
}
