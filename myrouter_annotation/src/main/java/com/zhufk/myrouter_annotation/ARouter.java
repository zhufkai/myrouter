package com.zhufk.myrouter_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName ARouter
 * @Description :
 *  生命周期：SOURCE < CLASS < RUNTIME
 *  1、一般如果需要在运行时去动态获取注解信息，用RUNTIME注解
 *  2、要在编译时进行一些预处理操作，如ButterKnife，用CLASS注解。注解会在class文件中存在，但是在运行时会被丢弃
 *  3、做一些检查性的操作，如@Override，用SOURCE源码注解。注解仅存在源码级别，在编译的时候丢弃该注解
 * @Author zhufk
 * @Date 2019/11/25 14:54
 * @Version 1.0
 */
@Target(ElementType.TYPE)// 该注解作用在类之上
@Retention(RetentionPolicy.CLASS)// 要在编译时进行一些预处理操作，注解会在class文件中存在
public @interface ARouter {
    // 详细路由路径（必填），如："/app/MainActivity"
    String path();

    // 路由组名（选填，如果开发者不填写，可以从path中截取出来）
    String group() default "";
}
