package Exception.package2;

public class ExceptionTest2 {

	static int a = 0 ,b = 0;//������main�����м���Ǿ�̬���� int a=0,b=0;
	public static void main(String args[]){
//		int a=0,b=0;
		double c;
		try{
			
		a =Integer.parseInt(args[0]);
		b =Integer.parseInt(args[1]);  //Integer.parseInt ת����Ϊ���εĶ���
		}catch(ArrayIndexOutOfBoundsException x){
			x.printStackTrace();
		}

		c = a/b;
		String m = Integer.toString(a);
		String n = Integer.toString(b);
		System.out.println(m+ "/"  + n + "=" +c);
		
	}
//	ExceptionTest2 TestDemo = new ExceptionTest2();
//	Dos��ִ��ʱ���� java ExceptionTest2 100 10   ����

}
