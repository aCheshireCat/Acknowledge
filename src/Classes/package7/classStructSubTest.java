package Classes.package7;

public class classStructSubTest extends classStructSuperTest{
	
	public classStructSubTest(){
		super();
		i = 20;
		System.out.println("Sub:"+i);
//		System.out.println(i);
	}
	public void changValue(){
		System.out.println("++i :"+ ++super.i);
	}
	
	
	
	
	

}
