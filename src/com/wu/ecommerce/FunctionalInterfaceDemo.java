package com.wu.ecommerce;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
	public int add(int a, int b);

	default void test() {
		System.out.println("functional interface demo default test method");
	}

	default void test2() {
		System.out.println("functional interface demo default test2 method");
	}

	default void test3() {
		System.out.println("functional interface demo default test3 method");
	}
}

class Test {
	public static void getResult(FunctionalInterfaceDemo functionInterface) {
		int result = functionInterface.add(10,2);
		System.out.println(result);
		functionInterface.test();
		functionInterface.test2();
	}
	public static void main(String[] args) {
		getResult((a,b)->a+b);
	}
}