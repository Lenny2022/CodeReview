package Annotation.Demo1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: lenny
 * @Date: 2022/6/25 22:48
 * @Description:
 */

//表示这个注解的存活时间是在编译时就存在的
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
