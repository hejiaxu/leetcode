/**
 * 
 */
package com.basic;

/**
 * Jiaxu
 * Mar 21, 2017
 * 
 */
public class InnerClass {
	public static void main(String[] args) {
		InnerClass test = new InnerClass();
		System.out.println(InnerClass.StaticInner.c);
		System.out.println(InnerClass.StaticInner.a);
		
		System.out.println(InnerClass.StaticInnerClass.c);
		System.out.println(InnerClass.StaticInnerString.c);
		System.out.println(InnerClass.StaticInnerString.d);
	}
	public class Inner{
		public static final int a = 1;
		public void b(){
			
		}
	}
	public static class StaticInner{
		
		static {
			System.out.println("aaaa");
		}
		public static int a = 1;
		public static final int c = 1;
		public static int b(){
			return a;
		}
	}
	public static class StaticInnerClass{
		
		static {
			System.out.println("ccc");
		}
		public static int a = 1;
		public static final Inner c = new InnerClass().new Inner();
	}
	public static class StaticInnerString{
		
		static {
			System.out.println("dddd");
		}
		public static final String c = "aaaa";
		public static final String d = new String("aaa");
	}
}
