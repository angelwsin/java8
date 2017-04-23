package com.java8.lib;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ParallelArrays {
	
	public static void main(String[] args) {
		 long[]  arrays = new long[2000];
		 Arrays.parallelSetAll(arrays, index->ThreadLocalRandom.current().nextLong(1000000));
		 Arrays.stream(arrays).limit(10).forEach(a->System.out.print(a+","));
		 Arrays.parallelSort(arrays);
		 System.out.println();
		 Arrays.stream(arrays).limit(10).forEach(a->System.out.print(a+","));
	}

}
