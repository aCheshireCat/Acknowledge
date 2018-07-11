package Array.package4;

public class ArrayStruct {

	private int a[];
	private String b[] = new String[3];
	private char c[] = new char[2];
	ArrayStruct() {
		
	}
	ArrayStruct(int[] a, String b[],char c[]) {
//		int i,j,k;
//		int length_a,length_b,length_c;
//  	length_a = a.length;
//		length_b = b.length;
//		length_c = c.length;
//		for(i=0;i<length_a;i++)
//			this.a[i] = a[i];
//		for(j=0;j<length_b;j++)
//			this.b[i] = b[i];
//		for(k=0;k<length_c;k++)
//			this.c[i] = c[i];	
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public void TestInit(){
		
		int d[] = {1,2,3};
		String e[] ={"123","abc"};
		char f[] = {'a','b','c'};

	}
	public void print(){
		int i,j,k;
		for(i=0;i<a.length;i++)
		System.out.println(a[i]);
		for(j=0;j<b.length;j++)
		System.out.println(b[j]);
		for(k=0;k<c.length;k++)
		System.out.println(c[k]);
		
	}
	
	
}
