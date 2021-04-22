package test03Reflect;

import domain.Person;

import java.lang.reflect.Field;

public class Demo02Reflect {
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
        //1.获取Person的class对象
        Class<Person> personClass = Person.class;
            /*	1.获取成员变量们*/

        //Field[] getFields()
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("----------------------------------------");

        Field field = personClass.getField("a");

        //获取成员变量field的值
        Person p = new Person();
        Object value = field.get(p);
        System.out.println(value);//null
        System.out.println("--------------------------");

        //设置成员变量field的值
        field.set(p,"lbz");
        System.out.println(p);//Person{name='null', age=0, a='lbz'}
        System.out.println("----------------------");

        //Field[] getDeclaredFields()
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("-----------------------");

        //Field getDeclaredFields(String name)
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检测
        d.setAccessible(true);//暴力反射
        Object value1 = d.get(p);
        System.out.println(value1);
    }
}
