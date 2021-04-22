package test04Annotation;
/*
        JDK预定义的注解：
            1.@Override:检测被该注解标注的方法是否继承父类（重写）

			2.@Deprecated：	将该注解标注的内容，表示已过时

			3.@SupperssWarnings： 压制警告
*
* */
@SuppressWarnings("all")
public class Demo02Annotation {
    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated
    public void show1(){

    }

    public void show2(){

    }


    public void demo(){
        show1();
    }
}
