package Exception.package2;

public class ExceptionTest2 {

	static int a = 0 ,b = 0;//或者在main函数中加入非静态变量 int a=0,b=0;
	public static void main(String args[]){
//		int a=0,b=0;
		double c;
		try{
			
		a =Integer.parseInt(args[0]);
		b =Integer.parseInt(args[1]);  //Integer.parseInt 转换成为整形的对象
		}catch(ArrayIndexOutOfBoundsException x){
			x.printStackTrace();
		}

		c = a/b;
		String m = Integer.toString(a);
		String n = Integer.toString(b);
		System.out.println(m+ "/"  + n + "=" +c);
		
	}
//	ExceptionTest2 TestDemo = new ExceptionTest2();
//	Dos下执行时输入 java ExceptionTest2 100 10   即可

}
