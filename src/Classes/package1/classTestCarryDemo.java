package Classes.package1;

public class classTestCarryDemo {

	public static void main(String args[])
	{
		
		classTestDemo Test = new classTestDemo();
		classTestSubDemo TestDemo = new classTestSubDemo();
		TestDemo.setBirth("2000-2-20");
		TestDemo.setSex("male");
		Test.getAge();
		Test.getName();
		System.out.println("----------");
		TestDemo.getName();
		System.out.println(TestDemo.getSex());
		System.out.println(TestDemo.getBirth());
	
		
		
		
	}
}
