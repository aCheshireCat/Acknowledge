package Classes.package6;

public class SubStructClassTest extends StructClassTest {
	
	
	
	public SubStructClassTest(){
		super();				//完全继承父类的构造函数，自身默认不带参数的构造函数已经
//		被重写了，也就是说它复制了父类构造函数下的全部信息到自身的构造函数下
		
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
