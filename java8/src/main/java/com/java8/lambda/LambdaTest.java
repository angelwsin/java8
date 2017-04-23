package com.java8.lambda;

import java.util.Arrays;
import java.util.function.Consumer;

//java8新特性 Lambda表达式和函数式接口 Lambda表达式（也叫做闭包） 之前使用匿名内部
public class LambdaTest {
	
        public static void main(String[] args) {
        	//匿名内部
        	Arrays.asList("a","b","c").forEach(new Consumer<String>() {

				@Override
				public void accept(String t) {
				      System.out.println(t);
				}
			});
        	// 参数列表-> 代码块    （类比匿名内部类中 要复写的函数参数和代码块
			//简单的Lambda表达式可以用逗号分隔的参数列表、->符号和功能语句块来表示
        	//如果参数列表为空 形式 ()->代码块
        	//一行语句
        	Arrays.asList("a","b","c").forEach(e->System.out.println(e));
        	//编译器会根据上下文来推测参数的类型，或者你也可以显示地指定参数类型，只需要将类型包在括号里
         //  参数 不加类型 编译器根据上下文推导
        	Arrays.asList("a","b","c").forEach((String e)->System.out.println(e));
        	//如果Lambda的功能语句块太复杂，我们可以用大括号包起来，跟普通的Java方法一样
        	//Lambda表达式可能会引用类的成员或者局部变量（会被隐式地转变成final类型）
        	//final String sp =",";
        	  String sp =",";
        	Arrays.asList("a","b","c").forEach((String e)->{
        		System.out.println(e+sp);
        	});
        	
        	//Lambda表达式可能会有返回值，编译器会根据上下文推断返回值的类型
        	//如果lambda的语句块只有一行，不需要return关键字
        	Arrays.asList("a","b","c").sort((o1,o2)->o1.compareTo(o2));
        	//多行需要 return 关键字
        	Arrays.asList("a","b","c").sort((o1,o2)->{
        		int  r = o1.compareTo(o2);
        		 return r;
        		});
		}

}
