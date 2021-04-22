package test04Annotation;
/*
*   * @Target：描述注解能够作用的位置
*           1.TYPE：可以作用于类上
			2.METHOD:可以作用于方法上
			3.FIELD:可以作用于成员变量上
			*
 * @Retention：描述注解被保留的阶段
 * @Documented:描述注解是否被抽取到api文档中
 * @Inherited：描述注解是否被子类继承
 * */

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE})//表示MyAnnotation注解只能作用于类上
public @interface MyAnnotation3 {

}
