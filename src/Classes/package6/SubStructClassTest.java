package Classes.package6;

public class SubStructClassTest extends StructClassTest {
	
	
	
	public SubStructClassTest(){
		super();				//��ȫ�̳и���Ĺ��캯��������Ĭ�ϲ��������Ĺ��캯���Ѿ�
//		����д�ˣ�Ҳ����˵�������˸��๹�캯���µ�ȫ����Ϣ������Ĺ��캯����
		
	}
	public void test1(){
		i=20;
		System.out.println(i);
	}
	
	public static void main(String args[]){
		
		SubStructClassTest test = new SubStructClassTest();
		test.test1();
		
	}
}
