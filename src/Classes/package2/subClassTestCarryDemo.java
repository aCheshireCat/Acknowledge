package Classes.package2;
public class subClassTestCarryDemo {
	public static void main(String args[]){
	
		subClassTestDemo subTest = new subClassTestDemo();
		subTest.setSex("male");
		subTest.setBirth("2012-2-3");//要求在package1下的setBirth方法必须为public
		subTest.setCloth("blue");
		subTest.setShoes("white");
		
		subTest.getAge();

		System.out.println(subTest.getBirth()+"\n"+subTest.getCloth());
		
		
	}

}
