package com.java8.javac;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 很长时间以来，Java程序员想尽办法把参数名字保存在java字节码里，并且让这些参数名字在运行时可用。
 * Java 8 终于把这个需求加入到了Java语言
 * （使用反射API和Parameter.getName() 方法）和字节码里（使用java编译命令javac的–parameters参数）
 * @author angel
 *额外的，有一个方便的方法Parameter.isNamePresent() 来验证参数名是不是可用
 */
public class JavaC {

	 public static void main(String[] args) throws Exception{
		   Method method =         JavaC.class.getMethod("main", String[].class);
		   Arrays.asList(method.getParameters()).forEach(p->System.out.println(p.getName()));
	}
}
