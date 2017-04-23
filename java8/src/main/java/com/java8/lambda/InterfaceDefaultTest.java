package com.java8.lambda;

import java.util.function.Supplier;

//默认方法和抽象方法的区别是抽象方法必须要被实现，默认方法不是。作为替代方式，接口可以提供一个默认的方法实现，
//所有这个接口的实现类都会通过继承得倒这个方法（如果有需要也可以重写这个方法）
////接口的默认方法和静态方法
public class InterfaceDefaultTest {
	
	   public static void main(String[] args) {
		   //::new 是构造方法引用
		Defaulable d = DefaultFactory.create(DefaultImpl::new);
		System.out.println(d.notRequire());
		Defaulable o = DefaultFactory.create(OverridableImpl::new);
		System.out.println(o.notRequire());
	}

}

interface Defaulable {
	default String notRequire(){
	    return " not require";
  }
}

class DefaultImpl implements Defaulable {
	
}

class OverridableImpl implements Defaulable {
	   @Override
	public String notRequire() {
		  return " not require 2";
	}
}
//接口里可以声明静态方法，并且可以实现
interface DefaultFactory{
	
	static Defaulable  create(Supplier<Defaulable> sup){
		      return sup.get();
	}
	
}
