package com.java8.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

//引入了重复注释，允许相同注释在声明使用的时候重复使用超过一次
//重复注释本身需要被@Repeatable注释

public class RepeatableAnnotationTest {

	public static void main(String[] args) {
		Arrays.asList(Filterable.class.getAnnotationsByType(Filter.class)).forEach(a->System.out.println(a.value()));
	}
	

}



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Filters{
	  Filter[]   value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Filters.class)
@interface  Filter{
	 String    value();
}

@Filter("filter2")
@Filter("filter1")
interface  Filterable{
	
}
