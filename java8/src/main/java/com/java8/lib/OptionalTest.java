package com.java8.lib;

import java.util.Optional;

/**
 * 著名的NullPointerException 是引起系统失败最常见的原因。
 * 很久以前Google Guava项目引入了Optional作为解决空指针异常的一种方式，
 * 不赞成代码被null检查的代码污染，期望程序员写整洁的代码。受Google Guava的鼓励，Optional 现在是Java 8库的一部分。

Optional 只是一个容器，它可以保存一些类型的值或者null。它提供很多有用的方法，所以没有理由不显式地检查null
 * @author angel
 *
 */
public class OptionalTest {

	public static void main(String[] args) {
		//可以为空
		Optional<String> fullName = Optional.ofNullable(null);
		System.out.println("Full Name is set? " + fullName.isPresent());
		System.out.println("Full Name "+fullName.orElseGet(()->"[none]"));
		System.out.println(fullName.map(s->"Hey"+s+"!").orElse( "Hey Stranger!"));
		System.out.println();
		notNull();
	}
	
	public static void notNull(){
		//不能为空
		Optional<String> fullName = Optional.of("Tom");
		System.out.println("Full Name is set? " + fullName.isPresent());
		System.out.println("Full Name "+fullName.orElseGet(()->"[none]"));
		System.out.println(fullName.map(s->"Hey"+s+"!").orElse( "Hey Stranger!"));
	}
}
