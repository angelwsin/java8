package com.java8.lambda;

//函数式编程
//函数接口。函数接口是一种只有一个方法的接口，像这样地，函数接口可以隐式地转换成lambda表达式
public class FunctionalInterfaceTest {

	 public static void main(String[] args) {
		
	}
}

//注解@FunctionalInterface 函数接口
@FunctionalInterface
interface   Action{
	  public void action();
}

//接口的默认方法和静态方法
interface ActionT{
	public void action();
	
	//默认的方法和静态方法（下一节会具体解释）不会违反函数接口的约定
	default void say(){
		System.out.println("hello ");
	}
}