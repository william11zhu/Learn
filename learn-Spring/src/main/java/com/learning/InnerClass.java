package com.learning;

public class InnerClass {

	private interface Content{
		public void run();
	}
		public Content createInnerClass(final String str) {
			return new Content() {
//				
//				static String name="";
//				static {
//					
//				}
//				public static void run(String name) {
//					
//				}
				@Override
				public void run() {
					String a = str;
					System.out.println(str);
					
				}

				
			};
			
			
			
		}
		
		class InnerClass2{
			public InnerClass2() {
				System.out.println("InnerClass2");
			}
		}
		
		public static void main(String... args) {
			InnerClass ic = new InnerClass();
			ic.createInnerClass("name").run();
			InnerClass2 ic2 = ic.new InnerClass2();
			
		}
}
