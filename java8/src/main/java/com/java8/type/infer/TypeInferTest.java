package com.java8.type.infer;

//更好的类型推断
public class TypeInferTest {

	 public static void main(String[] args) {
		Value<String> v = new Value<>();
		//java7中Value.< String >defaultValue()  
		System.out.println(v.get("z", Value.defaultValue()));
	}
	
}

class  Value<T>{
	
	public static <T> T  defaultValue(){
		        return null;
	}
	
	public  T  get(T v,T d){
		   return  v==null?d:v;
	}
}
