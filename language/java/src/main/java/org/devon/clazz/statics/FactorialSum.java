package org.devon.clazz.statics;

public class FactorialSum {

	public static void main(String[] args) {

		C c = new C();
		FactorialsSum(30);
	}
	public static void FactorialsSum(int x){
		int temp=1;
		int sum=0;
		for(int i=1;i<=x;i++){
					temp*=i;
					System.out.print(temp+",");
		}
		sum+=temp;
		System.out.println("\n"+sum);
	}

	static class C {
		public C(){
			System.out.println("CONSTRUCT C");
		}

		public void C(){
			System.out.println("method C");
		}
	}

}
