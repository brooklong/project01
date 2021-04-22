package test04Annotation;

public @interface MyAnnotation {
    int value();
    public int show1();
    Person per();
    MyAnnotation2 anno2();
    String[] strs();

//    String name() default "lbz";//默认值为lbz
  /*  String show2();
    Person per();//枚举类型
    MyAnnotation2 anno2();
    String[] strs();*/
}
