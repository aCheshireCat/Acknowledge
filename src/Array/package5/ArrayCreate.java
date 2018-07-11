package Array.package5;

import java.util.Arrays;

public class ArrayCreate {
	int[] a = new int[10];
	String[] b= new String[10];
	char[] c= new char[10];
	public void init()
	{
		int[] aa = new int[10];
		aa[0] = 1;
		aa[1] = 2;
//		aa[2] = 3;
		String[] bb ={"abc","bcd","dfg"};
		char[] cc = {'a','d','s'};
		try{
		System.arraycopy(aa, 0, a, 0, 3);//使用System.arraycopy方法来对数组进行复制
		System.arraycopy(bb, 0, b, 0, 3);
		System.arraycopy(cc, 0, c, 0, 3);
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw e;
		}	
	}
	public void print(){
//		int i;
//		for(i=0;i<a.length;i++)
//		System.out.println(a[i]);
//		for(i=0;i<b.length;i++)
//		System.out.println(b[i]);
//		for(i=0;i<c.length;i++)
//		System.out.println(c[i]);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
	}
		
}


