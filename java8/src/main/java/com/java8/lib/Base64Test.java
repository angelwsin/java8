package com.java8.lib;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

//Base64的支持最终成了Java 8标准库的一部分
public class Base64Test {
	
	
	 public static void main(String[] args) {
		   String   text = "Base64 finally in Java 8!";
		  String en =   Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
		  System.out.println(en);
		   byte[]   de =   Base64.getDecoder().decode(en);
		   System.out.println(new String(de,StandardCharsets.UTF_8));
	}
	

}
